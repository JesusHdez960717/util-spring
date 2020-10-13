/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.utils.spring.server;

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
public class RESTServiceTemplateFull<T> implements CRUDUseCase<T> {

    protected CRUDUseCase<T> uc;

    protected RESTServiceTemplateFull() {
    }

    public void setUseCase(CRUDUseCase<T> uc) {
        this.uc = uc;
    }

    @Override
    @PostMapping(RESTUrlConstants.PATH_TRABAJO_CREATE)
    public T create(@RequestBody T t) throws Exception {
        return uc.create(t);
    }

    @Override
    @GetMapping(RESTUrlConstants.PATH_TRABAJO_FIND_ALL)
    public List<T> findAll() throws Exception {
        return uc.findAll();
    }

    @Override
    @PostMapping(RESTUrlConstants.PATH_TRABAJO_EDIT)
    public T edit(@RequestBody T t) throws Exception {
        return uc.edit(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.PATH_TRABAJO_DESTROY)
    public T destroy(@RequestBody T t) throws Exception {
        return uc.destroy(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.PATH_TRABAJO_DESTROY_ID)
    public T destroyById(@RequestBody Object id) throws Exception {
        return uc.destroyById(id);
    }

    @Override
    @GetMapping(RESTUrlConstants.PATH_TRABAJO_FIND_BY)
    public T findBy(@PathVariable("id") Object id) throws Exception {
        return uc.findBy(Integer.parseInt(id.toString()));
    }

    @Override
    @GetMapping(RESTUrlConstants.PATH_TRABAJO_COUNT)
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
