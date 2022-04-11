/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dev.root101.spring.repo;

import dev.root101.clean.core.repo.external_repo.CRUDExternalRepository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author JesusHdezWaterloo@Github
 * @param <Entity>
 * @param <ID>
 */
public class DefaultJPARepository<Entity, ID> implements CRUDExternalRepository<Entity, ID> {

    private final JpaRepository<Entity, ID> repo;

    public DefaultJPARepository(JpaRepository repo) {
        this.repo = repo;
    }

    public JpaRepository<Entity, ID> repo() {
        return repo;
    }

    @Override
    public Entity create(Entity newObject) throws RuntimeException {
        return repo.save(newObject);
    }

    @Override
    public Entity edit(Entity objectToEdit) throws RuntimeException {
        return repo.save(objectToEdit);
    }

    @Override
    public void destroy(Entity objectToDestroy) throws RuntimeException {
        repo.delete(objectToDestroy);
    }

    @Override
    public void destroyById(ID keyId) throws RuntimeException {
        repo.deleteById(keyId);
    }

    @Override
    public Entity findBy(ID keyId) throws RuntimeException {
        return repo.findById(keyId).get();
    }

    @Override
    public List<Entity> findAll() throws RuntimeException {
        return repo.findAll();
    }

    @Override
    public long count() throws RuntimeException {
        return repo.count();
    }

}
