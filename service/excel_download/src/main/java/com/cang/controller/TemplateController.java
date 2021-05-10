package com.cang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TemplateController {

    @RequestMapping("/template")
    public String getTemplatePage(){
        return "index";
    }
}
