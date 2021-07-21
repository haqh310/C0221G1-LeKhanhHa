package com.codegym.model.service.impl;

import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.repository.contract.IContractRepository;
import com.codegym.model.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<Contract> findAll(String keyWord, Pageable pageable)  {
        Page<Contract> contracts= contractRepository.findAllByKeyWord(keyWord,pageable);
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date1 =null;
        Date date2 = null;
        for(Contract contract : contracts){
            try{
                date1=formatter.parse(contract.getContractStartDate());
                date2=formatter.parse(contract.getContractEndDate());
                double total= date2.compareTo(date1) * Double.parseDouble(contract.getService().getServiceCost());
                for(ContractDetail contractDetail : contract.getContractDetailSet()){
                    total += Double.parseDouble(contractDetail.getAttachService().getAttachServiceCost()) * Double.parseDouble(contractDetail.getQuantity());
                }
                contract.setContractTotalMoney(String.valueOf(total));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return contracts;
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        Contract contract = this.findById(id);
        contract.setFlag(false);
        save(contract);
    }
}
