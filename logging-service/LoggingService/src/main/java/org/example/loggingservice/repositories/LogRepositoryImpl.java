package org.example.loggingservice.repositories;

import org.example.loggingservice.entites.Log;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.util.List;

public class LogRepositoryImpl implements LogRepositoryCustom
{

    @Override
    public List<Log> findLogsWithCustomFilter(String filter) {
        return List.of();
    }
}
