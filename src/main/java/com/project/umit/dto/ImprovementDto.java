package com.project.umit.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ImprovementDto implements Serializable {
    private final String name;
    private final String email;
    private final String comment;
}
