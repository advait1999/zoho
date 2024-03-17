package com.zohocrm.controller;

import com.zohocrm.payload.EmailDto;
import com.zohocrm.service.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/emails")
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Operation(description = "API to send the email to customer, from this endpoint, instance will take the submitted email and message will be sent to particular mail id.")
    @ApiResponses(value={
            @ApiResponse(responseCode = "201", description = "Created Mail"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content(examples = @ExampleObject(value = "Kindly send the valid data."))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<EmailDto> sendEmail(@RequestBody EmailDto emailDto){
        EmailDto dto = emailService.sendEmail(emailDto);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
