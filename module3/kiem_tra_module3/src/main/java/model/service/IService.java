package model.service;

import model.bean.DanhMuc;

import java.util.List;

public interface IService<E> {
    List<E> findAll();

    E findById(int id);

    List<E> findByName(String name);

    boolean insert(E e);

    boolean update(E e);

    boolean remove(int id);

    List<DanhMuc> lisDanhMuc();
}
