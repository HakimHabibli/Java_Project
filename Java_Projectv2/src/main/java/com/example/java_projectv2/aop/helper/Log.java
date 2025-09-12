package com.example.java_projectv2.aop.helper;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class Log
{
    private RestTemplate restTemplate = new RestTemplate();

    public void writeLogToFile(String message) {
        String filePath = "C:\\Users\\ADMIN\\OneDrive\\Desktop\\Log.txt";
        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeLogToLogService(LogDto dto)
    {
        restTemplate.postForObject("http://localhost:8081/logs/create", dto, String.class);
        System.out.println(dto);
    }
}
