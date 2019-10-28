package com.syalar.sfg.recepies.repositories;

import com.syalar.sfg.recepies.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by jd.rodriguez
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
