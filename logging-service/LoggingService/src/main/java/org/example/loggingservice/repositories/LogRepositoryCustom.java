package org.example.loggingservice.repositories;

import org.example.loggingservice.entites.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepositoryCustom
{
    List<Log> findLogsWithCustomFilter(String filter);

}
