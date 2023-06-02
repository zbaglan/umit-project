package com.project.umit.service;

import com.project.umit.dto.FundDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface FundService {

    Page<FundDto> getAll(Pageable pageable);

    void addFund(Map<String, FundDto> fundDtoMap);

    FundDto getById(Long id);
}
