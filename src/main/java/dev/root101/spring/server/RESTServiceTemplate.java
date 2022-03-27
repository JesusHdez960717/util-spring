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
package dev.root101.spring.server;

import dev.root101.clean.core.app.usecase.CRUDUseCase;
import java.beans.PropertyChangeListener;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
    public T create(@RequestBody T t) throws RuntimeException {
        return uc.create(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.EDIT_PATH)
    public T edit(@RequestBody T t) throws RuntimeException {
        return uc.edit(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.DESTROY_PATH)
    public T destroy(@RequestBody T t) throws RuntimeException {
        return uc.destroy(t);
    }

    @Override
    @PostMapping(RESTUrlConstants.DESTROY_ID_PATH)
    public T destroyById(@RequestBody Object id) throws RuntimeException {
        return uc.destroyById(id);
    }

    @Override
    @GetMapping(RESTUrlConstants.FIND_ALL_PATH)
    public List<T> findAll() throws RuntimeException {
        return uc.findAll();
    }

    @Override
    @GetMapping(RESTUrlConstants.FIND_BY_PATH)
    public T findBy(@PathVariable(RESTUrlConstants.ID) Object id) throws RuntimeException {
        return uc.findBy(Integer.parseInt(id.toString()));
    }

    @Override
    @GetMapping(RESTUrlConstants.COUNT_PATH)
    public int count() throws RuntimeException {
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
