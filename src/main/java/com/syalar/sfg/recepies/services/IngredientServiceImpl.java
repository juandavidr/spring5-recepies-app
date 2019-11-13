package com.syalar.sfg.recepies.services;

import com.syalar.sfg.recepies.commands.IngredientCommand;
import com.syalar.sfg.recepies.converters.IngredientToIngredientCommand;
import com.syalar.sfg.recepies.domain.Recipe;
import com.syalar.sfg.recepies.repositories.IngredientRepository;
import com.syalar.sfg.recepies.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jd.rodriguez
 */
@Slf4j
@Service
public class IngredientServiceImpl implements IngredientService {
    private final IngredientRepository ingredientRepository;
    private final RecipeRepository recipeRepository;
    private final IngredientToIngredientCommand ingredientToIngredientCommand;

    public IngredientServiceImpl(IngredientRepository ingredientRepository,
            RecipeRepository recipeRepository,
            IngredientToIngredientCommand ingredientToIngredientCommand) {
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.ingredientToIngredientCommand = ingredientToIngredientCommand;
    }

    @Override public IngredientCommand findByRecipeIdIngredientAndId(Long recipeId, Long ingredientId) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(!recipeOptional.isPresent()){
            //todo impl error handling
            log.error("recipe id not found");
        }

        Recipe recipe = recipeOptional.get();

        Optional<IngredientCommand> ingredientCommandOptional = recipe.getIngredients().stream()
                .filter(ingredient -> ingredient.getId().equals(ingredientId))
        return ingredientToIngredientCommand.convert(ingredientRepository.findById(id).get());
    }
}
