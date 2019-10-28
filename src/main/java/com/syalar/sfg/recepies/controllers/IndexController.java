package com.syalar.sfg.recepies.controllers;

import com.syalar.sfg.recepies.domain.Category;
import com.syalar.sfg.recepies.domain.UnitOfMeasure;
import com.syalar.sfg.recepies.repositories.CategoryRepository;
import com.syalar.sfg.recepies.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

/**
 * Created by jd.rodriguez
 */
@Controller
public class IndexController {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @GetMapping({ "", "/", "/index" })
    public String getIndexPage() {
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Cat ID is: "+ categoryOptional.get().getId());
        System.out.println("UOM ID is: "+ unitOfMeasureOptional.get().getId());

        return "index";
    }

}
