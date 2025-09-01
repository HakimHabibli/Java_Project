package org.example.loggingservice.repositories;

import org.example.loggingservice.entites.Log;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class LogRepositoryImpl implements LogRepositoryCustom
{

    @Override
    public List<Log> findLogsWithCustomFilter(String filter)
    {
        return List.of();
    }
}
