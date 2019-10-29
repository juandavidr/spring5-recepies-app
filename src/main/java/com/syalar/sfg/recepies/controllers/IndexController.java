package com.syalar.sfg.recepies.controllers;

import com.syalar.sfg.recepies.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jd.rodriguez
 */
@Slf4j
@Controller
public class IndexController {

    private final RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        log.debug("getting all recipes in index page");
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }

}
