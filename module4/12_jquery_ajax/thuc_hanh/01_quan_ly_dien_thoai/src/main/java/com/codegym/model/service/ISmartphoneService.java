package com.codegym.model.service;

import com.codegym.model.entity.Smartphone;

import java.util.List;

public interface ISmartphoneService {
    List<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
