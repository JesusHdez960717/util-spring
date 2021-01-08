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

import com.root101.clean.core.app.repo.CRUDLightweightRepo;
import com.root101.clean.core.app.usecase.CRUDLightweightUseCase;
import com.root101.spring.server.RESTUrlConstants;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@Deprecated
public abstract class ConsumerRepoTemplateLight<Domain> extends ConsumerRepoTemplate<Domain> implements CRUDLightweightUseCase<Domain>, CRUDLightweightRepo<Domain> {

    public ConsumerRepoTemplateLight(Class<? extends Domain> clazz, String urlGeneral) {
        super(clazz, urlGeneral);
    }

    @Override
    public void create_light(Domain newObject) throws Exception {
        template().put(urlGeneral + RESTUrlConstants.CREATE_PATH_LIGHTWEIGHT, newObject);
    }

    @Override
    public void edit_light(Domain objectToUpdate) throws Exception {
        template().put(urlGeneral + RESTUrlConstants.EDIT_PATH_LIGHTWEIGHT, objectToUpdate);
    }

    @Override
    @Deprecated
    public void destroy_light(Domain objectToDestroy) throws Exception {
        template().delete(urlGeneral + RESTUrlConstants.DESTROY_PATH, objectToDestroy);
    }

    @Override
    @Deprecated
    public void destroyById_light(Object keyId) throws Exception {
        template().delete(urlGeneral + RESTUrlConstants.DESTROY_ID_PATH, keyId);
    }

}
