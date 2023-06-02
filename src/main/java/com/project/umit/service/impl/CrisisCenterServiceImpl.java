package com.project.umit.service.impl;

import com.project.umit.dto.CrisisCenterDto;
import com.project.umit.entity.CrisisCenter;
import com.project.umit.mapper.CrisisCenterMapper;
import com.project.umit.repository.CrisisCenterRepository;
import com.project.umit.service.CrisisCenterService;
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
public class CrisisCenterServiceImpl implements CrisisCenterService {

    private final CrisisCenterRepository crisisCenterRepository;
    private final CrisisCenterMapper crisisCenterMapper;

    @Override
    public Page<CrisisCenterDto> getCrisisCenters(Pageable pageable) {
        if (Objects.isNull(pageable)) {
            pageable = PageRequest.of(Constant.DEFAULT_PAGE, Constant.DEFAULT_SIZE);
        }

        List<CrisisCenter> crisisCenters = crisisCenterRepository.findAllByLocale(LocaleContextHolder.getLocale().getLanguage(), pageable);
        return new PageImpl<>(crisisCenterMapper.toDtos(crisisCenters));
    }

    @Override
    public void addCenter(Map<String, CrisisCenterDto> centerDtoMap) {
        Set<Map.Entry<String, CrisisCenterDto>> entries = centerDtoMap.entrySet();

        List<CrisisCenter> centers = entries.stream()
                .map(stringCrisisCenterDtoEntry -> {
                    CrisisCenter crisisCenter = crisisCenterMapper.toEntity(stringCrisisCenterDtoEntry.getValue());
                    crisisCenter.setLocale(stringCrisisCenterDtoEntry.getKey());
                    return crisisCenter;
                })
                .toList();


        crisisCenterRepository.saveAll(centers);
    }

    @Override
    public CrisisCenterDto getById(Long id) {
        CrisisCenter crisisCenter = crisisCenterRepository.getReferenceById(id);
        return crisisCenterMapper.toDto(crisisCenter);
    }
}
