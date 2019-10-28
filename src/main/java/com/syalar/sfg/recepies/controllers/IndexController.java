package com.syalar.sfg.recepies.controllers;

import com.syalar.sfg.recepies.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by jd.rodriguez
 */
@Controller
public class IndexController {

    private final RecipeService recipeService;

    @Autowired
    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage(Model model) {
        model.addAttribute("recipes", recipeService.findAll());
        return "index";
    }

}
