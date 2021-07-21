package model.service.Interface;

import model.bean.contract.AttachService;
import model.bean.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    List<ContractDetail> findListContractDetail(int id);

    ContractDetail findContractDetail(int id);

    List<AttachService> findAllAttachService();

    boolean insertContractDetail(ContractDetail contractDetail);

    boolean updateContractDetail(int id, ContractDetail contractDetail);

    boolean deleteContractDetail(int id);
}
