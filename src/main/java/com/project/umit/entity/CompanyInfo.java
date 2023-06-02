package com.project.umit.entity;

import com.project.umit.converter.StringListConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company_info")
public class CompanyInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String aboutUs;

    @Convert(converter = StringListConverter.class)
    private List<String> phones;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "companyInfo")
    private List<Person> team = new java.util.ArrayList<>();

}