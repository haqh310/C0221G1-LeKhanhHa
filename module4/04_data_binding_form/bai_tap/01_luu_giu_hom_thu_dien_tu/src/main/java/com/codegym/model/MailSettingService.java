package com.codegym.model;

import org.springframework.stereotype.Service;

@Service
public class MailSettingService {
    public MailSetting mailSetting;
    public MailSettingService(){
        mailSetting = new MailSetting("Vietnamese","15","1","abc");
    }
    public void update(MailSetting mailSetting1){
        mailSetting.setLanguage(mailSetting1.getLanguage());
        mailSetting.setSize(mailSetting1.getSize());
        mailSetting.setSpam(mailSetting1.getSpam());
        mailSetting.setSignature(mailSetting1.getSignature());
    }
}
