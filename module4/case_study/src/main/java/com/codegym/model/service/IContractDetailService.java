package com.codegym.model.service;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractDetailService extends IGenerateService<ContractDetail>{
    Page<ContractDetail> findByContractId(Long id, Pageable pageable);
    List<AttachService> listAttachService();
    List<ContractDetail> findAll();
}
