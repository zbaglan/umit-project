package com.project.umit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrisisCenterDto {
    private Long id;
    private String name;
    private String description;
    private List<String> phones;
    private String email;
    private String address;
    private String photo;
}
