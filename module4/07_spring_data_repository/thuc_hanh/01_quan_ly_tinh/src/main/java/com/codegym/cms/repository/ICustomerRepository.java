package com.codegym.cms.repository;

import com.codegym.cms.model.Customer;
import com.codegym.cms.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {

    Iterable<Customer> findAllByProvince(Province province);
}
