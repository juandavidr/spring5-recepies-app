package com.syalar.sfg.recepies.controllers;

import com.syalar.sfg.recepies.commands.IngredientCommand;
import com.syalar.sfg.recepies.services.IngredientService;
import com.syalar.sfg.recepies.services.RecipeService;
import com.syalar.sfg.recepies.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by jd.rodriguez
 */
@Slf4j
@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientService ingredientService;
    private final UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService,
                                IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
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

    @GetMapping("/recipe/{recipeId}/ingredient/{id}/update")
    public String updateRecipeIngredient(@PathVariable String recipeId, @PathVariable String id, Model model) {
        log.debug("update ingredient");
        model.addAttribute("ingredient",
                ingredientService.findByRecipeIdIngredientAndId(new Long(recipeId), new Long(id)));
        model.addAttribute("uomList", unitOfMeasureService.listAllUoms());
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping("recipe/{recipeId}/ingredient")
    public String saveOrUpdate(@ModelAttribute IngredientCommand ingredientCommand) {
        IngredientCommand savedIngredientCommand = ingredientService.saveIngredientCommand(ingredientCommand);
        log.debug("Saved recipeId:" + savedIngredientCommand.getRecipeId());
        log.debug("Saved ingredientId:" + savedIngredientCommand.getId());
        return "redirect:/recipe/" + savedIngredientCommand.getRecipeId() + "/ingredient/" + savedIngredientCommand.getId() + "/show";
    }

}
