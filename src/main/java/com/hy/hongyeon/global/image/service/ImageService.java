package com.hy.hongyeon.global.image.service;

import com.hy.hongyeon.global.image.entity.Image;
import com.hy.hongyeon.global.image.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image uploadImage(MultipartFile file){

        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\uploadImages\\";

        UUID uuid = UUID.randomUUID();
        String fileName = uuid + "_" + file.getOriginalFilename();
        File saveFile = new File(projectPath, fileName);

        try {
            //파일을 지정한 경로에 저장
            file.transferTo(saveFile);

            //이미지 URL 생성 (로컬 저장소에서 URL 형태로 변환)
            String imageUrl = "/uploadImages/" + fileName; // 실제 URL 경로에 맞게 수정

            //Image 엔티티 생성
            Image image = Image.builder()
                    .name(file.getOriginalFilename())
                    .path(imageUrl)
                    .build();

            //DB에 이미지 정보 저장
            imageRepository.save(image);

            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
