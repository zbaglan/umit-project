package com.project.umit.controller;

import com.project.umit.dto.HelplineDto;
import com.project.umit.service.HelplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/helpline")
@RequiredArgsConstructor
public class HelplineController {

    private final HelplineService helplineService;

    @GetMapping("/all")
    public List<HelplineDto> getAllHelplines() {
        return helplineService.getAll();
    }
}
