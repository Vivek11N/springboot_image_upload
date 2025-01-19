package com.example.finalimage.Controllers;

import com.example.finalimage.Services.TextContentService;
import com.example.finalimage.model.TextContent;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/textContents")
public class TextContentController {
    private final TextContentService textContentService;

    public TextContentController(TextContentService textContentService) {
        this.textContentService = textContentService;
    }

    @PostMapping
    public ResponseEntity<TextContent> addTextContent(@RequestBody TextContent textContent) {
        return ResponseEntity.ok(textContentService.addTextContent(textContent));
    }

    @GetMapping
    public ResponseEntity<List<TextContent>> getAllTextContents() {
        return ResponseEntity.ok(textContentService.getAllTextContents());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTextContent(@PathVariable Long id) {
        textContentService.deleteTextContent(id);
        return ResponseEntity.noContent().build();
    }
}
