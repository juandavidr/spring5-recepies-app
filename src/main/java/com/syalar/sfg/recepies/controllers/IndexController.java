package com.syalar.sfg.recepies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jd.rodriguez
 */
@Controller
public class IndexController {

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage() {
        return "index";
    }

}
