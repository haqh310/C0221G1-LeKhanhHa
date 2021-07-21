package model.service.impl;

import model.bean.contract.AttachService;
import model.bean.contract.ContractDetail;
import model.repository.ContractDetailRepository;
import model.service.Interface.IContractDetailService;
import model.service.common.Validate;

import java.util.List;

public class ContractDetailServiceImpl implements IContractDetailService {
    ContractDetailRepository contractDetailRepository = new ContractDetailRepository();
    Validate validate = new Validate();

    @Override
    public List<ContractDetail> findListContractDetail(int id) {
        return contractDetailRepository.findListContractDetail(id);
    }

    @Override
    public ContractDetail findContractDetail(int id) {
        return contractDetailRepository.findContractDetail(id);
    }

    @Override
    public List<AttachService> findAllAttachService() {
        return contractDetailRepository.findAllAttachService();
    }

    @Override
    public boolean insertContractDetail(ContractDetail contractDetail) {
        try{
            validate.validateTypeInt(contractDetail.getQuantity());
            return contractDetailRepository.insertContractDetail(contractDetail);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateContractDetail(int id, ContractDetail contractDetail) {
        try{
            validate.validateTypeInt(contractDetail.getQuantity());
            return contractDetailRepository.updateContractDetail(id, contractDetail);
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean deleteContractDetail(int id) {
        return contractDetailRepository.deleteContractDetail(id);
    }
}
