package com.zohocrm.payload;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    @Schema(description = "Mail Id to whom you want to send the mail",
            name = "to",
            example = "murli@example.com",
            requiredMode = Schema.RequiredMode.REQUIRED)
    private String to;

    @Schema(description = "Subject of mail",
            name = "subject",
            example = "Profile created")
    private String subject;

    @Schema(description = "Message to be sent",
            name = "message",
            example = "Hi Murli, <br> Your profile have been updated in our system. \n Thanks,\n CRM Team")
    private String message;
}
