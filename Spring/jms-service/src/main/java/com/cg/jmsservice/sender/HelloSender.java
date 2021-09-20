package com.cg.jmsservice.sender;

import com.cg.jmsservice.config.JmsConfig;
import com.cg.jmsservice.model.HelloWorldMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class HelloSender {

    private final JmsTemplate jmsTemplate;
    private final ObjectMapper mapper;

    @Scheduled(fixedRate = 2000)
    public void sendMessage(){
        System.out.println("I'm sending a message.");
        HelloWorldMessage message = HelloWorldMessage.builder()
                                                     .id(UUID.randomUUID())
                                                     .message("Hello World")
                                                     .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, message);

        System.out.println("Message sent!");
    }

    @Scheduled(fixedRate = 2000)
    public void sendAndReceiveMessage() throws JMSException{
        System.out.println("I'm sending a message.");
        HelloWorldMessage message = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello")
                .build();

        Message receivedMessage = jmsTemplate.sendAndReceive(JmsConfig.SEND_AND_RECEIVE_QUEUE, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message helloMessage = null;
                try {
                    helloMessage = session.createTextMessage(mapper.writeValueAsString(message));
                    helloMessage.setStringProperty("_type", "package com.cg.jmsservice.model.HelloWorldMessage");

                    System.out.println("Sending hello...");
                    return helloMessage;

                } catch (JsonProcessingException e) {
                    throw new JMSException("Error");
                }
            }
        });
        System.out.println(receivedMessage.getBody(String.class));
    }
}
