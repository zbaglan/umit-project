package com.project.umit.service.impl;

import com.project.umit.dto.ArticleDto;
import com.project.umit.entity.Article;
import com.project.umit.mapper.ArticleMapper;
import com.project.umit.repository.ArticleRepository;
import com.project.umit.service.ArticleService;
import com.project.umit.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;

    @Override
    public Page<ArticleDto> getAllArticles(Pageable pageable) {
        if (Objects.isNull(pageable)) {
            pageable = PageRequest.of(Constant.DEFAULT_PAGE, Constant.DEFAULT_SIZE);
        }

        List<Article> articles = articleRepository.findAllByLocale(LocaleContextHolder.getLocale().getLanguage(), pageable);
        return new PageImpl<>(articleMapper.toDtos(articles));
    }

    @Override
    public ArticleDto getById(Long id) {
        Article article = articleRepository.getReferenceById(id);
        return articleMapper.toDto(article);
    }

    @Override
    public void addArticle(Map<String, ArticleDto> articleDtoMap) {
        Set<Map.Entry<String, ArticleDto>> entries = articleDtoMap.entrySet();

        List<Article> articles = entries.stream()
                .map(stringArticleDtoEntry -> {
                    Article article = articleMapper.toEntity(stringArticleDtoEntry.getValue());
                    article.setLocale(stringArticleDtoEntry.getKey());
                    return article;
                })
                .toList();


        articleRepository.saveAll(articles);
    }

    @Override
    public List<ArticleDto> searchArticles(String title) {
        List<Article> articles = articleRepository.findByTitleContaining(title);
        return articleMapper.toDtos(articles);
    }
}
