package com.project.umit.dto;

import lombok.Data;

@Data
public class FeedbackDto {
    private Integer rate;
    private String comment;
    private String email;
    private String improvement;
}
