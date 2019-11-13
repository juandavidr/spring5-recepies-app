package com.syalar.sfg.recepies.services;

import com.syalar.sfg.recepies.commands.IngredientCommand;

/**
 * Created by jd.rodriguez
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdIngredientAndId(Long recipeId, Long ingredientId);
}
