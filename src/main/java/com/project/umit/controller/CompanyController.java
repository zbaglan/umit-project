package com.project.umit.controller;

import com.project.umit.dto.FeedbackDto;
import com.project.umit.dto.ImprovementDto;
import com.project.umit.dto.Response;
import com.project.umit.entity.CompanyInfo;
import com.project.umit.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping("/about")
    public CompanyInfo aboutCompany() {
        return companyService.aboutCompany();
    }

    @PostMapping("/feedback")
    public Response leaveFeedback(@RequestBody FeedbackDto dto) {
        companyService.leaveFeedback(dto);
        return Response.ok();
    }

    @PostMapping("/improvement")
    public Response leaveImprovement(@RequestBody ImprovementDto dto) {
        companyService.leaveImprovement(dto);
        return Response.ok();
    }
}
