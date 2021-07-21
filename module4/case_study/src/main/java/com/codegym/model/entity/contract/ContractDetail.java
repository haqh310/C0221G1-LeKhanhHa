package com.codegym.model.entity.contract;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;

    private String quantity;
    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    private Contract contract;

    private boolean flag;

    public ContractDetail() {
    }
}
