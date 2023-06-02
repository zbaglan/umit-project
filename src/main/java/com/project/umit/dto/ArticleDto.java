package com.project.umit.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ArticleDto implements Serializable {
    private final Long id;
    private final String title;
    private final String author;
    private final LocalDate createdDate;
    private final String description;
    private final String photo;
}
