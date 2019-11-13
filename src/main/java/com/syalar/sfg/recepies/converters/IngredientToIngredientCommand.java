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
public class IngredientToIngredientCommand implements Converter<Ingredient,IngredientCommand> {
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public IngredientCommand convert(Ingredient source) {
        if (source == null) {
            return null;
        }
        final IngredientCommand ingredient = new IngredientCommand();
        ingredient.setId(source.getId());
        ingredient.setUnitOfMeasure(unitOfMeasureConverter.convert(source.getUom()));
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());

        return ingredient;
    }
}
