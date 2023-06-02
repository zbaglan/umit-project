package com.project.umit.mapper;

import com.project.umit.dto.ArticleDto;
import com.project.umit.entity.Article;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ArticleMapper {
    Article toEntity(ArticleDto articleDto);

    ArticleDto toDto(Article article);

    List<ArticleDto> toDtos(List<Article> articles);
    List<Article> toEntities(List<ArticleDto> dtos);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Article updateArticleFromArticleDto(ArticleDto articleDto, @MappingTarget Article article);
}
