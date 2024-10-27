package com.hy.hongyeon.global.image.repository;

import com.hy.hongyeon.global.image.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
