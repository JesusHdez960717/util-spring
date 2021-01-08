/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.spring.client;

import com.root101.clean.core.app.repo.CRUDRepository;
import com.root101.clean.core.app.usecase.CRUDUseCase;
import com.root101.spring.server.RESTUrlConstants;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class ConsumerRepoTemplate<Domain> implements CRUDRepository<Domain>, CRUDUseCase<Domain> {

    protected final Class<? extends Domain> clazz;
    protected final String urlGeneral;

    public ConsumerRepoTemplate(Class<? extends Domain> clazz, String urlGeneral) {
        this.clazz = clazz;
        this.urlGeneral = urlGeneral;
    }

    protected abstract RestOperations template();

    @Override
    public Domain create(Domain newObject) throws Exception {
        return template().postForObject(urlGeneral + RESTUrlConstants.CREATE_PATH, newObject, clazz);
    }

    @Override
    public Domain edit(Domain objectToEdit) throws Exception {
        return template().postForObject(urlGeneral + RESTUrlConstants.EDIT_PATH, objectToEdit, clazz);
    }

    @Override
    public Domain destroy(Domain objectToDestroy) throws Exception {
        return template().postForObject(urlGeneral + RESTUrlConstants.DESTROY_PATH, objectToDestroy, clazz);
    }

    @Override
    public Domain destroyById(Object keyId) throws Exception {
        return template().postForObject(urlGeneral + RESTUrlConstants.DESTROY_ID_PATH, keyId, clazz);
    }

    @Override
    public Domain findBy(Object keyId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(RESTUrlConstants.ID, keyId);
        return template().getForObject(urlGeneral + RESTUrlConstants.FIND_BY_PATH, clazz, map);
    }

    @Override
    public List<Domain> findAll() throws Exception {
        return (List<Domain>) RestTemplateUtils.getForList(template(), urlGeneral + RESTUrlConstants.FIND_ALL_PATH, clazz);
    }

    @Override
    public int count() throws Exception {
        return template().getForObject(urlGeneral + RESTUrlConstants.COUNT_PATH, Integer.class);
    }

    @Override
    @Deprecated
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    @Deprecated
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

}
