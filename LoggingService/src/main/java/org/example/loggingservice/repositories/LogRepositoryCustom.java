package org.example.loggingservice.repositories;

import org.example.loggingservice.entites.Log;
import java.util.List;

public interface LogRepositoryCustom
{
    List<Log> findLogsWithCustomFilter(String filter);

}
