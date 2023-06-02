package com.project.umit.mapper;

import com.project.umit.dto.HelplineDto;
import com.project.umit.entity.Helpline;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HelplineMapper {

    HelplineDto toDto(Helpline helpline);

    List<HelplineDto> toDtos(List<Helpline> helplines);

    Helpline toEntity(HelplineDto dto);

    List<Helpline> toEntities(List<HelplineDto> dtos);
}
