package com.example.finalimage.Repositories;

import com.example.finalimage.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByOrderByDisplayOrderAsc();
}

