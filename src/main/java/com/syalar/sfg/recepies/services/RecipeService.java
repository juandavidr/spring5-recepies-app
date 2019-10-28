package com.syalar.sfg.recepies.services;

import com.syalar.sfg.recepies.domain.Recipe;

import java.util.Set;

/**
 * Created by jd.rodriguez
 */
public interface RecipeService {

    public Set<Recipe> findAll();
}
