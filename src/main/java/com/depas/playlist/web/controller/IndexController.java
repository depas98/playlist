package com.depas.playlist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping(value = "/")
    public String index(Model m) {
        m.addAttribute("someAttribute", "Index Test Some Attr");

        return "index";
    }
}
