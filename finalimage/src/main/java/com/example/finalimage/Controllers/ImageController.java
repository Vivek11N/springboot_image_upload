package com.example.finalimage.Controllers;
import com.example.finalimage.Services.ImageService;
import com.example.finalimage.model.Image;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<Image> addImage(@RequestParam("image") MultipartFile image,
                                          @RequestParam("displayOrder") int displayOrder) throws IOException {
        Image img = new Image();
        img.setImageData(image.getBytes());
        img.setDisplayOrder(displayOrder);
        img.setImageName(image.getOriginalFilename());
        return ResponseEntity.ok(imageService.addImage(img));
    }

    @GetMapping()
    public ResponseEntity<List<Image>> getAllImages() {
        return ResponseEntity.ok(imageService.getAllImages());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/order")
    public ResponseEntity<Void> updateOrder(@RequestBody List<Image> images) {
        imageService.updateDisplayOrder(images);
        return ResponseEntity.noContent().build();
    }
}

