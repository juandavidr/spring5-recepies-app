package com.syalar.sfg.recepies.repositories;

import com.syalar.sfg.recepies.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
