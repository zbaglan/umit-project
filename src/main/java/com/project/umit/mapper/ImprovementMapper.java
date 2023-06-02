package com.project.umit.mapper;

import com.project.umit.dto.ImprovementDto;
import com.project.umit.entity.Improvement;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ImprovementMapper {
    Improvement toEntity(ImprovementDto improvementDto);

    ImprovementDto toDto(Improvement improvement);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Improvement updateImprovementFromImprovementDto(ImprovementDto improvementDto, @MappingTarget Improvement improvement);
}
