package com.codegym.controller;

import com.codegym.model.MailSetting;
import com.codegym.model.MailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailController {
    @Autowired
    MailSettingService mailSettingService;

    @GetMapping(value = {"/","/setting"})
    public ModelAndView goSetting(){
        ModelAndView modelAndView = new ModelAndView("setting", "mailSetting", mailSettingService.mailSetting);
        return modelAndView;
    }

    @PostMapping("/setting")
    public ModelAndView update(@ModelAttribute("mailSetting") MailSetting mailSetting){
        mailSettingService.update(mailSetting);
        ModelAndView modelAndView = new ModelAndView("setting", "mailSetting", mailSettingService.mailSetting);
        return modelAndView;
    }


}
