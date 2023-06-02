package com.project.umit.service;

import com.project.umit.dto.ArticleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    Page<ArticleDto> getAllArticles(Pageable pageable);

    ArticleDto getById(Long id);

    void addArticle(Map<String, ArticleDto> articleDtoMap);

    List<ArticleDto> searchArticles(String name);
}
