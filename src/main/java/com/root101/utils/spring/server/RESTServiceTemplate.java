/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.utils.spring.server;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import java.beans.PropertyChangeListener;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 * @param <T>
 */
@RestController
public class RESTServiceTemplate<T> implements CRUDUseCase<T> {

    protected CRUDUseCase<T> uc;

    protected RESTServiceTemplate() {
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
    @PostMapping(RESTUrlConstants.EDIT_PATH)
    public T edit(@RequestBody T t) throws Exception {
        return uc.edit(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.DESTROY_PATH)
    public T destroy(@RequestBody T t) throws Exception {
        return uc.destroy(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.DESTROY_ID_PATH)
    public T destroyById(@RequestBody Object id) throws Exception {
        return uc.destroyById(id);
    }

    @Override
    @GetMapping(RESTUrlConstants.FIND_ALL_PATH)
    public List<T> findAll() throws Exception {
        return uc.findAll();
    }

    @Override
    @GetMapping(RESTUrlConstants.FIND_BY_PATH)
    public T findBy(@PathVariable(RESTUrlConstants.ID) Object id) throws Exception {
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
