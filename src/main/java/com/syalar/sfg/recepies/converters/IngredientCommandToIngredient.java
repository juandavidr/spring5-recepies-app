package com.syalar.sfg.recepies.converters;

import com.syalar.sfg.recepies.commands.IngredientCommand;
import com.syalar.sfg.recepies.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by jd.rodriguez
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {
    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }
        final Ingredient ingredient = new Ingredient();
        ingredient.setId(source.getId());
        ingredient.setUom(unitOfMeasureConverter.convert(source.getUnitOfMeasure()));
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());

        return ingredient;
    }
}
