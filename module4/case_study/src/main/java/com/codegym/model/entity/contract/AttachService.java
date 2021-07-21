package com.codegym.model.entity.contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class AttachService {
    @Id
    private Long attachServiceId;
    private String attachServiceName;
    private String attachServiceCost;
    private String attachServiceUnit;
    private String attachServiceStatus;

    @OneToMany(mappedBy = "attachService")
    private Set<ContractDetail> contractDetails;
    public AttachService() {
    }
}
