package model.service.impl;

import model.bean.contract.Contract;
import model.repository.ContractRepository;
import model.service.Interface.IContractService;
import model.service.common.Validate;

import java.util.List;

public class ContractServiceImpl implements IContractService {
    private ContractRepository contractRepository = new ContractRepository();
    Validate validate = new Validate();

    @Override
    public List<String[]> findCustomerContract() {
        return contractRepository.findCustomerContract();
    }

    @Override
    public List<String[]> findContractByName(String name) {
        return contractRepository.findContractByName(name);
    }

    @Override
    public Contract findContractById(int contract_id) {
        return contractRepository.findContractById(contract_id);
    }

    @Override
    public boolean insertContract(Contract contract) {
        try{
            validate.validateDate(contract.getContract_start_date());
            validate.validateDate(contract.getContract_end_date());
            validate.validateTypeDouble(contract.getContract_deposit());
            return contractRepository.insertContract(contract);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateContract(int id, Contract contract) {
        try{
            validate.validateDate(contract.getContract_start_date());
            validate.validateDate(contract.getContract_end_date());
            validate.validateTypeDouble(contract.getContract_deposit());
            return contractRepository.updateContract(id, contract);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteContract(int contract_id) {
        return contractRepository.deleteContract(contract_id);
    }
}
