package com.enoca.employee_management.model.service;

import java.util.List;

public interface EntityService<E,L> {

    List<E> getAll();

    E findByID(L id);

    E save(E entity);

    void deleteById(L id);

    E update(E entity);
}
