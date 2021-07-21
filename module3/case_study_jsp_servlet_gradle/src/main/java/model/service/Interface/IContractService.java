package model.service.Interface;

import model.bean.contract.Contract;

import java.util.List;

public interface IContractService {
    List<String[]> findCustomerContract();
    List<String[]> findContractByName(String name);

    Contract findContractById(int contract_id);

    boolean insertContract(Contract contract);

    boolean updateContract(int id, Contract contract);

    boolean deleteContract(int contract_id);
}
