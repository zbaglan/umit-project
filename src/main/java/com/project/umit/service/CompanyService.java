package com.project.umit.service;

import com.project.umit.dto.FeedbackDto;
import com.project.umit.dto.ImprovementDto;
import com.project.umit.entity.CompanyInfo;

public interface CompanyService {
    CompanyInfo aboutCompany();

    void leaveFeedback(FeedbackDto dto);

    void leaveImprovement(ImprovementDto dto);
}
