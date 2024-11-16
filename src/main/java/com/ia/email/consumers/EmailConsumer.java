package com.ia.email.consumers;

import com.ia.email.dtos.EmailRecordDtos;
import com.ia.email.models.EmailModel;
import com.ia.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {

    final EmailService emailService;

    public EmailConsumer(EmailService emailService) {
        this.emailService = emailService;
    }

    @RabbitListener(queues = "${broker.queue.email.name}" )
    public void listenEmailQueue(@Payload EmailRecordDtos emailRecordDtos) {
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDtos, emailModel);



    }
}
