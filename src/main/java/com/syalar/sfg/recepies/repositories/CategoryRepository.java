package com.syalar.sfg.recepies.repositories;

import com.syalar.sfg.recepies.domain.Category;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jd.rodriguez
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
