package org.example.loggingservice.controllers;



import org.springframework.http.ResponseEntity;
import org.example.loggingservice.services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController
{
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmail()
    {
        emailService.senEmail("hakim.habibli03@gmail.com","Test","Test ucun gonderilen mail");
        return ResponseEntity.ok("Mesaj gonderildi");
    }
}
