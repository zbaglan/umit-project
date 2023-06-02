package com.project.umit.service;

import com.project.umit.dto.CrisisCenterDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface CrisisCenterService {

    Page<CrisisCenterDto> getCrisisCenters(Pageable pageable);

    void addCenter(Map<String, CrisisCenterDto> centerDtoMap);

    CrisisCenterDto getById(Long id);
}
