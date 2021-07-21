package model.repository;

import java.util.List;

public interface IRepository<E> {
    List<E> findAll();

    E findById(int id);

    List<E> findByName(String name);
    boolean insert(E E);

    boolean update(int id, E e);

    boolean delete(int id);
}
