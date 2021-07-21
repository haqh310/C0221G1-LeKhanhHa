package model.service;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    E findById(int id);

    List<E> findByName(String name);

    boolean save(E e);

    boolean update(int id, E e);

    boolean remove(int id);
}
