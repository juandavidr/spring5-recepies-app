package com.syalar.sfg.recepies.commands;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by jd.rodriguez
 */
@Setter
@Getter
@EqualsAndHashCode(exclude = "recipe")
public class IngredientCommand {

    private Long id;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand unitOfMeasure;
}
