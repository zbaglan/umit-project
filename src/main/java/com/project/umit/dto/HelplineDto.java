package com.project.umit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HelplineDto {
    private Long id;
    private String name;
    private String description;
    private List<String> phones;
}
