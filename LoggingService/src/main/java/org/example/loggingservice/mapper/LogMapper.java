package org.example.loggingservice.mapper;


import org.example.loggingservice.dtos.LogDto;
import org.example.loggingservice.entites.Log;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LogMapper {
    LogDto toLogDto(Log log);
    List<LogDto> toLogDto(List<Log> logs);
    Log toLog(LogDto log);
}
