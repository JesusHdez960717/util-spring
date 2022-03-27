/*
 * Copyright 2022 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
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
package dev.root101.spring.client;

import dev.root101.clean.core.app.repo.CRUDRepositoryConsume;
import dev.root101.spring.server.RESTUrlConstants;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public abstract class ConsumerRepoTemplate<Domain> implements CRUDRepositoryConsume<Domain> {

    protected final Class<? extends Domain> clazz;
    protected final String urlGeneral;
    protected final Supplier<RestOperations> template;

    public ConsumerRepoTemplate(Class<? extends Domain> clazz, String urlGeneral, Supplier<RestOperations> template) {
        this.clazz = clazz;
        this.urlGeneral = urlGeneral;
        this.template = template;
    }

    /**
     * Si se crea con este constructor simpre va a devolver el mismo
     * RestOperations, y si este cambia en Runtime las instancias de esta clase
     * ya creadas van a seguir usando el RestOperations viejo.
     *
     * @param clazz
     * @param urlGeneral
     * @param template
     * @deprecated
     */
    @Deprecated
    public ConsumerRepoTemplate(Class<? extends Domain> clazz, String urlGeneral, RestOperations template) {
        this.clazz = clazz;
        this.urlGeneral = urlGeneral;
        this.template = () -> template;
    }

    protected RestOperations template() {
        return template.get();
    }

    @Override
    public Domain create(Domain newObject) throws RuntimeException {
        return template().postForObject(urlGeneral + RESTUrlConstants.CREATE_PATH, newObject, clazz);
    }

    @Override
    public Domain edit(Domain objectToEdit) throws RuntimeException {
        return template().postForObject(urlGeneral + RESTUrlConstants.EDIT_PATH, objectToEdit, clazz);
    }

    @Override
    public Domain destroy(Domain objectToDestroy) throws RuntimeException {
        return template().postForObject(urlGeneral + RESTUrlConstants.DESTROY_PATH, objectToDestroy, clazz);
    }

    @Override
    public Domain destroyById(Object keyId) throws RuntimeException {
        return template().postForObject(urlGeneral + RESTUrlConstants.DESTROY_ID_PATH, keyId, clazz);
    }

    @Override
    public Domain findBy(Object keyId) throws RuntimeException {
        Map<String, Object> map = new HashMap<>();
        map.put(RESTUrlConstants.ID, keyId);
        return template().getForObject(urlGeneral + RESTUrlConstants.FIND_BY_PATH, clazz, map);
    }

    @Override
    public List<Domain> findAll() throws RuntimeException {
        return (List<Domain>) RestTemplateUtils.getForList(template(), urlGeneral + RESTUrlConstants.FIND_ALL_PATH, clazz);
    }

    @Override
    public int count() throws RuntimeException {
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
