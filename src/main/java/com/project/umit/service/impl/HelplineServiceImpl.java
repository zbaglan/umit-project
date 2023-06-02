package com.project.umit.service.impl;

import com.project.umit.dto.HelplineDto;
import com.project.umit.entity.Fund;
import com.project.umit.entity.Helpline;
import com.project.umit.mapper.HelplineMapper;
import com.project.umit.repository.HelplineRepository;
import com.project.umit.service.HelplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HelplineServiceImpl implements HelplineService {

    private final HelplineRepository helplineRepository;
    private final HelplineMapper helplineMapper;

    @Override
    public List<HelplineDto> getAll() {
        List<Helpline> helplines = helplineRepository.findAllByLocale(LocaleContextHolder.getLocale().getLanguage());
        return helplineMapper.toDtos(helplines);
    }
}
