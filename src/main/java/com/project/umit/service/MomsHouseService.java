package com.project.umit.service;

import com.project.umit.dto.MomsHouseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface MomsHouseService {

    Page<MomsHouseDto> getAll(Pageable pageable);

    void addMomsHouse(Map<String, MomsHouseDto> momsHouseDtoMap);

    MomsHouseDto getById(Long id);
}
