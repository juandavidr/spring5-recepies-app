package com.syalar.sfg.recepies.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by jd.rodriguez
 */
public interface ImageService {
    void saveImageFile(Long anyLong, MultipartFile any);
}
