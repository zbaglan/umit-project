package com.project.umit.service.impl;

import com.project.umit.dto.MomsHouseDto;
import com.project.umit.entity.MomsHouse;
import com.project.umit.mapper.MomsHouseMapper;
import com.project.umit.repository.MomsHouseRepository;
import com.project.umit.service.MomsHouseService;
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
public class MomsHouseServiceImpl implements MomsHouseService {

    private final MomsHouseRepository momsHouseRepository;
    private final MomsHouseMapper momsHouseMapper;

    @Override
    public Page<MomsHouseDto> getAll(Pageable pageable) {
        if (Objects.isNull(pageable)) {
            pageable = PageRequest.of(Constant.DEFAULT_PAGE, Constant.DEFAULT_SIZE);
        }
        List<MomsHouse> momsHouses = momsHouseRepository.findAllByLocale(LocaleContextHolder.getLocale().getLanguage(), pageable);
        List<MomsHouseDto> momsHousesDtos = momsHouseMapper.toDtos(momsHouses);

        return new PageImpl<>(momsHousesDtos);
    }

    @Override
    public void addMomsHouse(Map<String, MomsHouseDto> momsHouseDtoMap) {
        Set<Map.Entry<String, MomsHouseDto>> entries = momsHouseDtoMap.entrySet();

        List<MomsHouse> momesHouses = entries.stream()
                .map(entry -> {
                    MomsHouse momsHouse = momsHouseMapper.toEntity(entry.getValue());
                    momsHouse.setLocale(entry.getKey());
                    return momsHouse;
                })
                .toList();

        momsHouseRepository.saveAll(momesHouses);
    }

    @Override
    public MomsHouseDto getById(Long id) {
        MomsHouse momsHouse = momsHouseRepository.getReferenceById(id);
        return momsHouseMapper.toDto(momsHouse);
    }
}
