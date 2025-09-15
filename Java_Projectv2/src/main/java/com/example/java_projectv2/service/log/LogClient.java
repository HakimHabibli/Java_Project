package com.example.java_projectv2.service.log;
import com.example.java_projectv2.dto.log.LogDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class LogClient
{
//    private RestTemplate restTemplate = new RestTemplate();
    private final WebClient webClient ;

    public LogClient(WebClient.Builder builder)
    {
        this.webClient = builder.baseUrl("http://localhost:8081/logs").build();
    }

    public void writeLogToLogServiceAsync(LogDto dto)
    {
//        restTemplate.postForObject("http://localhost:8081/logs/create", dto, String.class);

            webClient.post()
                .uri("/create")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(dto)
                .retrieve()
                    .toBodilessEntity()
                .subscribe();


        System.out.println(dto);
    }

    public void writeLogToFile(String message) {
        String filePath = "C:\\Users\\ADMIN\\OneDrive\\Desktop\\Log.txt";
        try (FileWriter fw = new FileWriter(filePath, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
