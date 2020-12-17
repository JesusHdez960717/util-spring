/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.client;

import com.clean.core.app.repo.CRUDRepository;
import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.utils.spring.server.RESTUrlConstants;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <Domain>
 */
public class ConsumerRepoTemplate<Domain> implements CRUDRepository<Domain>, CRUDUseCase<Domain> {

    protected final RestOperations template;
    protected final Class<? extends Domain> clazz;
    protected final String urlGeneral;

    public ConsumerRepoTemplate(RestOperations template, Class<? extends Domain> clazz, String urlGeneral) {
        this.template = template;
        this.clazz = clazz;
        this.urlGeneral = urlGeneral;
    }

    @Override
    public Domain create(Domain newObject) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.CREATE_PATH, newObject, clazz);
    }

    @Override
    public Domain edit(Domain objectToEdit) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.EDIT_PATH, objectToEdit, clazz);
    }

    @Override
    public Domain destroy(Domain objectToDestroy) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.DESTROY_PATH, objectToDestroy, clazz);
    }

    @Override
    public Domain destroyById(Object keyId) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.DESTROY_ID_PATH, keyId, clazz);
    }

    @Override
    public Domain findBy(Object keyId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put(RESTUrlConstants.ID, keyId);
        return template.getForObject(urlGeneral + RESTUrlConstants.FIND_BY_PATH, clazz, map);
    }

    @Override
    public List<Domain> findAll() throws Exception {
        return (List<Domain>) RestTemplateUtils.getForList(template, urlGeneral + RESTUrlConstants.FIND_ALL_PATH, clazz);
    }

    @Override
    public int count() throws Exception {
        return template.getForObject(urlGeneral + RESTUrlConstants.COUNT_PATH, Integer.class);
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
