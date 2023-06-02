package com.project.umit.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Response {
    private HttpStatus status;
    private String message;

    private Response(HttpStatus status) {
        this.status = status;
    }

    private Response(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public static Response ok() {
        return new Response(HttpStatus.OK);
    }

    public static Response created() {
        return new Response(HttpStatus.CREATED);
    }

    public static Response error(String message) {
        return new Response(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}
