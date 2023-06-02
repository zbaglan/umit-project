package com.project.umit.service.impl;

import com.project.umit.dto.FundDto;
import com.project.umit.entity.Fund;
import com.project.umit.mapper.FundMapper;
import com.project.umit.repository.FundRepository;
import com.project.umit.service.FundService;
import com.project.umit.util.Constant;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FundServiceImpl implements FundService {

    private final FundRepository fundRepository;
    private final FundMapper fundMapper;

    @Override
    public Page<FundDto> getAll(Pageable pageable) {
        if (Objects.isNull(pageable)) {
            pageable = PageRequest.of(Constant.DEFAULT_PAGE, Constant.DEFAULT_SIZE);
        }
        List<Fund> funds = fundRepository.findAllByLocale(LocaleContextHolder.getLocale().getLanguage(), pageable);
        List<FundDto> fundDtos = fundMapper.toDtos(funds);

        return new PageImpl<>(fundDtos);
    }

    @Override
    public void addFund(Map<String, FundDto> fundDtoMap) {
        Set<Map.Entry<String, FundDto>> entries = fundDtoMap.entrySet();

        List<Fund> funds = entries.stream()
                .map(entry -> {
                    Fund fund = fundMapper.toEntity(entry.getValue());
                    fund.setLocale(entry.getKey());
                    return fund;
                })
                .toList();

        fundRepository.saveAll(funds);
    }

    @Override
    public FundDto getById(Long id) {
        Fund fund = fundRepository.getReferenceById(id);
        return fundMapper.toDto(fund);
    }
}
