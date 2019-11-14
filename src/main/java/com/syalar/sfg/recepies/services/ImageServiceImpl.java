package com.syalar.sfg.recepies.services;

import com.syalar.sfg.recepies.domain.Recipe;
import com.syalar.sfg.recepies.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by jd.rodriguez
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    private RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void saveImageFile(Long id, MultipartFile multipartFile) {
        log.debug("Received a file");
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if (!recipeOptional.isPresent()) {
            log.error("no recipe found");
        } else {
            Recipe recipe = recipeOptional.get();
            try {
                Byte[] byteObjs = new Byte[multipartFile.getBytes().length];
                for (int i = 0; i < multipartFile.getBytes().length; i++) {
                    byteObjs[i] = multipartFile.getBytes()[i];
                }
                recipe.setImage(byteObjs);
                recipeRepository.save(recipe);
            } catch (IOException e) {
                log.error("ERROR OCCURRED", e);
                e.printStackTrace();
            }
        }

    }
}
