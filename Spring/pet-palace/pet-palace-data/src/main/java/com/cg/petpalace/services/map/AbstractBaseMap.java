package com.cg.petpalace.services.map;

import com.cg.petpalace.model.BaseEntity;

import java.util.*;

public abstract class AbstractBaseMap<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {
        if (object == null) {
            throw new RuntimeException("Object cannot be null.");
        } else {
            if (object.getId() == null) {
                object.setId(generateId());
                map.put(object.getId(), object);
            }
        }
        return object;
    }

    void delete(T object) {
        map.entrySet().removeIf(item -> item.getValue().equals(object));
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    private Long generateId() {
        Long id = null;

        try {
            id = Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException ex) {
            id = 1L;
        }
        return id;
    }
}
