/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.client;

import com.clean.core.app.repo.CRUDRepository;
import com.jhw.utils.spring.server.RESTUrlConstants;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <Domain>
 */
public class ConsumerRepoTemplate<Domain> implements CRUDRepository<Domain> {

    protected final RestTemplate template;
    protected final Class<? extends Domain> clazz;
    protected final String urlGeneral;

    public ConsumerRepoTemplate(RestTemplate template, Class<? extends Domain> clazz, String urlGeneral) {
        this.template = template;
        this.clazz = clazz;
        this.urlGeneral = urlGeneral;
    }

    @Override
    public Domain create(Domain newObject) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.PATH_TRABAJO_CREATE, newObject, clazz);
    }

    @Override
    public Domain edit(Domain objectToEdit) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.PATH_TRABAJO_EDIT, objectToEdit, clazz);
    }

    @Override
    public Domain destroy(Domain objectToDestroy) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.PATH_TRABAJO_DESTROY, objectToDestroy, clazz);
    }

    @Override
    public Domain destroyById(Object keyId) throws Exception {
        return template.postForObject(urlGeneral + RESTUrlConstants.PATH_TRABAJO_DESTROY_ID, keyId, clazz);
    }

    @Override
    public Domain findBy(Object keyId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("id", keyId);
        return template.getForObject(urlGeneral + RESTUrlConstants.PATH_TRABAJO_FIND_BY, clazz, map);
    }

    @Override
    public List<Domain> findAll() throws Exception {
        ParameterizedTypeReference<List<Domain>> type = new ParameterizedTypeReference<List<Domain>>() {
        };
        ResponseEntity<List<Domain>> response = template.exchange(urlGeneral + RESTUrlConstants.PATH_TRABAJO_FIND_ALL, HttpMethod.GET, null, type);
        return response.getBody();
    }

    @Override
    public int count() throws Exception {
        return template.getForObject(urlGeneral + RESTUrlConstants.PATH_TRABAJO_COUNT, Integer.class);
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
