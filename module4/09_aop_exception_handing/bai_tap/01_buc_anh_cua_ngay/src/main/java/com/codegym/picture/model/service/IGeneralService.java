package com.codegym.picture.model.service;


import com.codegym.picture.exception.BadWordException;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T findById(Long id);

    void save(T t) throws BadWordException;

    void remove(Long id);
}