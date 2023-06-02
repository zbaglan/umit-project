package com.project.umit.dto;

import lombok.Data;

import java.util.List;

@Data
public class MomsHouseDto {
    private Long id;
    private String name;
    private String description;
    private List<String> phones;
    private String email;
    private String address;
    private String site;
    private String photo;
}
