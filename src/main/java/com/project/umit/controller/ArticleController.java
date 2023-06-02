package com.project.umit.controller;

import com.project.umit.dto.ArticleDto;
import com.project.umit.dto.Response;
import com.project.umit.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping
    public Response addArticle(@RequestBody Map<String, ArticleDto> articleDtoMap) {
        articleService.addArticle(articleDtoMap);
        return Response.ok();
    }

    @GetMapping("/all")
    public Page<ArticleDto> getAllArticles(Pageable pageable) {
        return articleService.getAllArticles(pageable);
    }

    @GetMapping("/{id}")
    public ArticleDto getById(@PathVariable("id") Long id) {
        return articleService.getById(id);
    }

    @GetMapping("/search")
    public List<ArticleDto> searchArticles(@RequestParam("title") String title) {
        return articleService.searchArticles(title);
    }
}
