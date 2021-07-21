package model.service;

import model.bean.contract.AttachService;
import model.bean.contract.Contract;
import model.bean.contract.ContractDetail;
import model.repository.ContractRepository;

import java.util.List;

public class ContractService {
    private ContractRepository contractRepository = new ContractRepository();
    public List<Contract> findAllContract(){
        return contractRepository.findAllContract();
    }

    public List<ContractDetail> findAllContractDetail(){
        return contractRepository.findAllContractDetail();
    }
    public List<AttachService> findAllAttachService(){
        return contractRepository.findAllAttachService();
    }

    public void insertContract(Contract contract) {
        contractRepository.insertContract(contract);
    }
    public void insertContractDetail(ContractDetail contractDetail) {
        contractRepository.insertContractDetail(contractDetail);
    }
}
