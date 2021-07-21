package com.codegym.model.repository;

import com.codegym.model.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Long> {
}
