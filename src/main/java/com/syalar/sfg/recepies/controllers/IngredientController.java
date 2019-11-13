package com.syalar.sfg.recepies.controllers;

import com.syalar.sfg.recepies.services.IngredientService;
import com.syalar.sfg.recepies.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by jd.rodriguez
 */
@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;

    public IngredientController(RecipeService recipeService,
            IngredientService ingredientService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping("/recipe/{id}/ingredients")
    public String getRecipeIngredients(@PathVariable String id, Model model) {
        log.debug("getting recipe ingredients for re");
        model.addAttribute("recipe", recipeService.findCommandById(new Long(id)));
        return "recipe/ingredient/list";
    }

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/show")
    public String showIngredient(@PathVariable String recipeId, @PathVariable String id, Model model) {
        log.debug("showing ingredient");
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdIngredientAndId(new Long(recipeId), new Long(id)));
        return "recipe/ingredient/show";
    }
}
