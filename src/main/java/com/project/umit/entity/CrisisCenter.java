package com.project.umit.entity;

import com.project.umit.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "crisis_centers")
public class CrisisCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;

    private String description;

    @Convert(converter = StringListConverter.class)
    private List<String> phones;

    private String email;

    private String address;

    private String photo;

    private String locale;
}