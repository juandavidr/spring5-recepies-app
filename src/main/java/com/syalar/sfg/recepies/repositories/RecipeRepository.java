package com.syalar.sfg.recepies.repositories;

import com.syalar.sfg.recepies.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
