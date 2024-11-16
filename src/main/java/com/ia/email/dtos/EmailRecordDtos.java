package com.ia.email.dtos;


import java.util.UUID;

public record EmailRecordDtos(UUID UserId,
                              String emailTo,
                              String subject,
                              String text) {
}
