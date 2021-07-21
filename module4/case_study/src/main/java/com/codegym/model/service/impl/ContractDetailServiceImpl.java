package com.codegym.model.service.impl;

import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.repository.contract.IAttachServiceRepository;
import com.codegym.model.repository.contract.IContractDetailRepository;
import com.codegym.model.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public Page<ContractDetail> findAll(String keyWord, Pageable pageable) {
        return null;
    }

    @Override
    public ContractDetail findById(Long id) {
        return contractDetailRepository.findById(id).orElse(null);
    }

    @Override
    public void save(ContractDetail contractDetail) {
     for(ContractDetail contractDetail1 : this.findAll()){
       boolean check = (contractDetail1.getContract().getId() == contractDetail.getContract().getId()) && (contractDetail.getAttachService().getAttachServiceId() == contractDetail1.getAttachService().getAttachServiceId()) && (contractDetail1.isFlag());
        if(check){
            int quantity =Integer.parseInt(contractDetail1.getQuantity())+ Integer.parseInt(contractDetail.getQuantity());
            contractDetail1.setQuantity(String.valueOf(quantity));
            contractDetailRepository.save(contractDetail1);
            return;
        }
     }
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public void remove(Long id) {
        ContractDetail contractDetail = this.findById(id);
        contractDetail.setFlag(false);
        this.save(contractDetail);
    }

    @Override
    public Page<ContractDetail> findByContractId(Long id,Pageable pageable) {
        return contractDetailRepository.findAllByContractId(id,pageable);
    }

    @Override
    public List<AttachService> listAttachService() {
        return attachServiceRepository.findAll();
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
