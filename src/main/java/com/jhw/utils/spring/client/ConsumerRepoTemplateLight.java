/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.client;

import com.clean.core.app.repo.CRUDLightweightRepo;
import com.clean.core.app.usecase.CRUDLightweightUseCase;
import com.jhw.utils.spring.server.RESTUrlConstants;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <Domain>
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
