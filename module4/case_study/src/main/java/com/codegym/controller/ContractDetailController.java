package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.entity.contract.AttachService;
import com.codegym.model.entity.contract.Contract;
import com.codegym.model.entity.contract.ContractDetail;
import com.codegym.model.service.IContractDetailService;
import com.codegym.model.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/contract_details")
@SessionAttributes("user")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @ModelAttribute("attachServices")
    public List<AttachService> attachServices(){
        return contractDetailService.listAttachService();
    }

    @GetMapping(value = "")
    public ModelAndView goList(@RequestParam Long id,
                               @RequestParam("page") Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        Page<ContractDetail> contractDetails = contractDetailService.findByContractId(id, pageable);
        ModelAndView modelAndView = new ModelAndView("contract_detail/list", "contractDetails", contractDetails);
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public ModelAndView showFormCreate(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("/contract_detail/create","contractDetailDto", new ContractDetailDto());
        modelAndView.addObject("id",id);
        return modelAndView;
    }
    @PostMapping(value = "/create")
    public String createContractDetail(@ModelAttribute @Valid ContractDetailDto contractDetailDto,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes){
        if(bindingResult.hasFieldErrors()){
            return "/contract_detail/create";
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        contractDetailService.save(contractDetail);
        Long  id = contractDetail.getContract().getId();
        redirectAttributes.addFlashAttribute("msg","create new contract detail successfully!!!");
        return "redirect:/contract_details?id="+id;
    }

    @PostMapping(value = "/delete")
    public String deleteContractDetail(@RequestParam("id") Long id,
                                       @RequestParam("contract_detail_id") Long contract_detail_id,
                                       RedirectAttributes redirectAttributes){
        contractDetailService.remove(contract_detail_id);
        redirectAttributes.addFlashAttribute("msg","Delete contract detail successfully!!!");
        return "redirect:/contract_details?id="+id;
    }
}
