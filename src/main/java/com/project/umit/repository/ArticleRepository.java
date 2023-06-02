package com.project.umit.repository;

import com.project.umit.entity.Article;
import com.project.umit.entity.CrisisCenter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByLocale(String locale, Pageable pageable);

    List<Article> findByTitleContaining(String title);
}