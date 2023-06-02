package com.project.umit.mapper;

import com.project.umit.dto.MomsHouseDto;
import com.project.umit.entity.MomsHouse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MomsHouseMapper {

    MomsHouseDto toDto(MomsHouse momsHouse);

    List<MomsHouseDto> toDtos(List<MomsHouse> momsHouses);

    MomsHouse toEntity(MomsHouseDto dto);

    List<MomsHouse> toEntities(List<MomsHouseDto> dtos);
}
