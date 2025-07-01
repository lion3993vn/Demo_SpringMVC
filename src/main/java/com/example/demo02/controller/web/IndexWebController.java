package com.example.demo02.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexWebController {

    @GetMapping("/")
    public String index() {
        return "login.html";
    }
}
