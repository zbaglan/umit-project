package com.project.umit.service.impl;

import com.project.umit.dto.FeedbackDto;
import com.project.umit.dto.ImprovementDto;
import com.project.umit.entity.CompanyInfo;
import com.project.umit.entity.Feedback;
import com.project.umit.entity.Improvement;
import com.project.umit.mapper.FeedbackMapper;
import com.project.umit.mapper.ImprovementMapper;
import com.project.umit.repository.CompanyInfoRepository;
import com.project.umit.repository.FeedbackRepository;
import com.project.umit.repository.ImprovementRepository;
import com.project.umit.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyInfoRepository companyInfoRepository;
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepository feedbackRepository;
    private final ImprovementMapper improvementMapper;
    private final ImprovementRepository improvementRepository;

    @Override
    public CompanyInfo aboutCompany() {
        List<CompanyInfo> all = companyInfoRepository.findAll();
        if (!all.isEmpty()) {
            return all.get(0);
        }

        return null;
    }

    @Override
    public void leaveFeedback(FeedbackDto dto) {
        Feedback feedback = feedbackMapper.toEntity(dto);
        feedbackRepository.save(feedback);
    }

    @Override
    public void leaveImprovement(ImprovementDto dto) {
        Improvement improvement = improvementMapper.toEntity(dto);
        improvementRepository.save(improvement);
    }
}
