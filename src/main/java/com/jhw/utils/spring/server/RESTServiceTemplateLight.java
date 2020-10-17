/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.server;

import com.clean.core.app.usecase.CRUDLightweightUseCase;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T>
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
