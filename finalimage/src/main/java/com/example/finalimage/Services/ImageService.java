package com.example.finalimage.Services;

import com.example.finalimage.Repositories.ImageRepository;
import com.example.finalimage.model.Image;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public Image addImage(Image image) {
        return imageRepository.save(image);
    }

    @Transactional
    public List<Image> getAllImages() {
        return imageRepository.findAllByOrderByDisplayOrderAsc();
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public void updateDisplayOrder(List<Image> images) {
        imageRepository.saveAll(images);
    }
}
