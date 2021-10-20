package com.cg.msscservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@Configuration
public class JmsConfig {

    public static final String VALIDATE_ORDER_QUEUE = "validate-order";// - Read from
    public static final String VALIDATE_ORDER_RESPONSE_QUEUE = "validate-order-response";// - Send response to
    public static final String BREWING_REQUEST_QUEUE = "brewing-request";
    public static final String INVENTORY_REQUEST_QUEUE = "new-inventory";

    //Allows Spring to take a JMS messsage being sent and transcode it to a JSON message for delivery to receiver.
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper){
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        converter.setObjectMapper(objectMapper); // - Using Spring Boot Object Mapper

        return converter;
    }
}
