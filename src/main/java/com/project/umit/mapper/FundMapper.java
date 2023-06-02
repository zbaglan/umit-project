package com.project.umit.mapper;

import com.project.umit.dto.FundDto;
import com.project.umit.entity.Fund;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FundMapper {

    FundDto toDto(Fund fund);

    List<FundDto> toDtos(List<Fund> funds);

    Fund toEntity(FundDto dto);

    List<Fund> toEntities(List<FundDto> dtos);
}
