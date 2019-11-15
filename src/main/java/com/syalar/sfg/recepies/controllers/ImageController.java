package com.syalar.sfg.recepies.controllers;

import com.syalar.sfg.recepies.commands.RecipeCommand;
import com.syalar.sfg.recepies.services.ImageService;
import com.syalar.sfg.recepies.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by jd.rodriguez
 */
@Controller
public class ImageController {

    private final ImageService imageService;
    private final RecipeService recipeService;

    public ImageController(ImageService imageService, RecipeService recipeService) {
        this.imageService = imageService;
        this.recipeService = recipeService;
    }

    @GetMapping("recipe/{id}/image")
    public String getImage(@PathVariable String id, Model model) {

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));
        return "recipe/imageuploadform";
    }

    @PostMapping("recipe/{id}/image")
    public String uploadImage(@PathVariable String id, @RequestParam("imagefile") MultipartFile file) {

        imageService.saveImageFile(Long.valueOf(id), file);
        return "redirect:/recipe/" + id + "/show";
    }

    @GetMapping("/recipe/{id}/recipeimage")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws IOException {
        RecipeCommand command = recipeService.findCommandById(Long.valueOf(id));
        if (command.getImage() != null) {
            byte[] byteObjs = new byte[command.getImage().length];
            for (int i = 0; i < command.getImage().length; i++) {
                byteObjs[i] = command.getImage()[i];
            }
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            InputStream is = new ByteArrayInputStream(byteObjs);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

}
