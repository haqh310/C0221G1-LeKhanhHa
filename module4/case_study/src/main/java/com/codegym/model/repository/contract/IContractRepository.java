package com.codegym.model.repository.contract;

import com.codegym.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IContractRepository extends JpaRepository<Contract,Long> {
    @Query(value = "select * from contract ct join customer c on ct.customer_id = c.customer_id where c.customer_name like %?1% && ct.flag=1", nativeQuery = true)
    Page<Contract> findAllByKeyWord(String keyWord, Pageable pageable);
}
