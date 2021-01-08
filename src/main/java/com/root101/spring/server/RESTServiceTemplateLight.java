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
package com.root101.spring.server;

import com.root101.clean.core.app.usecase.CRUDLightweightUseCase;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@RestController
@Deprecated
public class RESTServiceTemplateLight<T> extends RESTServiceTemplate<T> implements CRUDLightweightUseCase<T> {

    protected CRUDLightweightUseCase<T> lightUC;

    protected RESTServiceTemplateLight() {
    }

    public void setUseCase(CRUDLightweightUseCase<T> uc) {
        this.lightUC = uc;
        super.setUseCase(uc);
    }

    @Override
    @PutMapping(path = RESTUrlConstants.CREATE_PATH_LIGHTWEIGHT)
    public void create_light(@RequestBody T newObject) throws Exception {
        lightUC.create_light(newObject);
    }

    @Override
    @PutMapping(RESTUrlConstants.EDIT_PATH_LIGHTWEIGHT)
    public void edit_light(@RequestBody T objectToUpdate) throws Exception {
        lightUC.edit_light(objectToUpdate);
    }

    @Override
    @DeleteMapping(RESTUrlConstants.DESTROY_PATH_LIGHTWEIGHT)
    @Deprecated
    public void destroy_light(@RequestBody T objectToDestroy) throws Exception {
        lightUC.destroy_light(objectToDestroy);
    }

    @Override
    @DeleteMapping(RESTUrlConstants.DESTROY_ID_PATH)
    @Deprecated
    public void destroyById_light(Object keyId) throws Exception {
        lightUC.destroyById_light(keyId);
    }

}
