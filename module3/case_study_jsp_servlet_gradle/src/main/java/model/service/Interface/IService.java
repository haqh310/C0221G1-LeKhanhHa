package model.service.Interface;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    E findById(int id);

    List<E> findByName(String name);

    List<String> insert(E e);

    List<String> update(int id, E e);

    boolean remove(int id);
}
