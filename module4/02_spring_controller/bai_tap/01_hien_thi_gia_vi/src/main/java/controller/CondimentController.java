package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

   @PostMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment, ModelMap modelMap) {
        modelMap.addAttribute("condiment",condiment);
        return "result";
    }

}
