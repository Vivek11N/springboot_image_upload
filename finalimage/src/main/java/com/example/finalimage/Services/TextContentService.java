package com.example.finalimage.Services;


import com.example.finalimage.Repositories.TextContentRepository;
import com.example.finalimage.model.TextContent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TextContentService {
    private final TextContentRepository textContentRepository;

    public TextContentService(TextContentRepository textContentRepository) {
        this.textContentRepository = textContentRepository;
    }

    public TextContent addTextContent(TextContent textContent) {
        return textContentRepository.save(textContent);
    }

    public List<TextContent> getAllTextContents() {
        return textContentRepository.findAll();
    }

    public void deleteTextContent(Long id) {
        textContentRepository.deleteById(id);
    }
}
