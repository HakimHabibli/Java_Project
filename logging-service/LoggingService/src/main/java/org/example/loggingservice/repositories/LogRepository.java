package org.example.loggingservice.repositories;


import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LogRepository
    extends JpaRepository<Log,Long>,LogRepositoryCustom
{
    List<Log> findByLevel (LogLevel level);
}
