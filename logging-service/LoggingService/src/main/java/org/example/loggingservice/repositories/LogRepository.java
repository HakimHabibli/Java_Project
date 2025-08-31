package org.example.loggingservice.repositories;


import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository
    extends MongoRepository<Log,String>,LogRepositoryCustom
{
    List<Log> findByLevel (LogLevel level);
}
