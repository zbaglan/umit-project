package com.project.umit.mapper;

import com.project.umit.dto.CrisisCenterDto;
import com.project.umit.entity.CrisisCenter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CrisisCenterMapper {
    CrisisCenterDto toDto(CrisisCenter crisisCenter);

    List<CrisisCenterDto> toDtos(List<CrisisCenter> crisisCenter);

    CrisisCenter toEntity(CrisisCenterDto dto);

    List<CrisisCenter> toEntities(List<CrisisCenterDto> dtos);
}
