package com.project.umit.mapper;

import com.project.umit.dto.FeedbackDto;
import com.project.umit.entity.Feedback;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    Feedback toEntity(FeedbackDto feedbackDto);

    FeedbackDto toDto(Feedback feedback);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Feedback updateFeedbackFromFeedbackDto1(FeedbackDto feedbackDto, @MappingTarget Feedback feedback);
}
