/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.server;

import com.clean.core.app.usecase.CRUDLightweightUseCase;
import com.clean.core.app.usecase.CRUDUseCase;
import java.beans.PropertyChangeListener;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T>
 */
@RestController
public class RESTServiceTemplateFull<T> implements CRUDLightweightUseCase<T> {

    protected CRUDUseCase<T> uc;

    protected RESTServiceTemplateFull() {
    }

    public void setUseCase(CRUDUseCase<T> uc) {
        this.uc = uc;
    }

    @Override
    @PostMapping(path = RESTUrlConstants.CREATE_PATH)
    public T create(@RequestBody T t) throws Exception {
        return uc.create(t);
    }

    @Override
    @PutMapping(path = RESTUrlConstants.CREATE_PATH_LIGHTWEIGHT)
    public void create_ligth(@RequestBody T newObject) throws Exception {
        CRUDLightweightUseCase.super.create_ligth(newObject);
    }

    @Override
    @PostMapping(RESTUrlConstants.EDIT_PATH)
    public T edit(@RequestBody T t) throws Exception {
        return uc.edit(t);
    }

    @Override
    @PutMapping(RESTUrlConstants.EDIT_PATH_LIGHTWEIGHT)
    public void edit_ligth(T objectToUpdate) throws Exception {
        CRUDLightweightUseCase.super.edit_ligth(objectToUpdate);
    }

    @Override
    @PostMapping(RESTUrlConstants.DESTROY_PATH)
    public T destroy(@RequestBody T t) throws Exception {
        return uc.destroy(t);
    }

    @Override
    @DeleteMapping(RESTUrlConstants.DESTROY_PATH_LIGHTWEIGHT)
    public void destroy_ligth(T objectToDestroy) throws Exception {
        CRUDLightweightUseCase.super.destroy_ligth(objectToDestroy);
    }

    @Override
    @PostMapping(RESTUrlConstants.DESTROY_ID_PATH)
    public T destroyById(@RequestBody Object id) throws Exception {
        return uc.destroyById(id);
    }

    @Override
    @DeleteMapping(RESTUrlConstants.DESTROY_ID_PATH)
    public void destroyById_ligth(Object keyId) throws Exception {
        CRUDLightweightUseCase.super.destroyById_ligth(keyId);
    }

    @Override
    @GetMapping(RESTUrlConstants.FIND_ALL_PATH)
    public List<T> findAll() throws Exception {
        return uc.findAll();
    }

    @Override
    @GetMapping(RESTUrlConstants.FIND_BY_PATH)
    public T findBy(@PathVariable("id") Object id) throws Exception {
        return uc.findBy(Integer.parseInt(id.toString()));
    }

    @Override
    @GetMapping(RESTUrlConstants.COUNT_PATH)
    public int count() throws Exception {
        return uc.count();
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener pl) {
        uc.addPropertyChangeListener(pl);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener pl) {
        uc.removePropertyChangeListener(pl);
    }

}
