package com.contoso.kafka;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

import com.contoso.kafka.entity.Header;
import com.contoso.kafka.entity.KafkaEntity;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;


import java.util.Optional;

public class FunctionOutput {
    /*@FunctionName("KafkaOutput")
    public HttpResponseMessage input(
            @HttpTrigger(name = "req", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            @KafkaOutput(name = "kafkaOutput",
                         topic = "topic", 
                         brokerList="BrokerList",
                         username = "$ConnectionString",
                         password = "%KafkaPassword%",
                         authenticationMode = BrokerAuthenticationMode.PLAIN,
                         protocol = BrokerProtocol.SASLSSL)  OutputBinding<KafkaEntity> output,
            final ExecutionContext context) {
        context.getLogger().info("Java HTTP trigger processed a request.");

        // Parse query parameter
        String query = request.getQueryParameters().get("message");
        String message = request.getBody().orElse(query);
        context.getLogger().info("Message:" + message);
        Header header = new Header("headKey", "headValue");
        Header[] headers = new Header[1];
        headers[0] = header;
        KafkaEntity kafkaEntity = new KafkaEntity(1, 100,
                "newHub",
                (new Timestamp(System.currentTimeMillis())).toString(),
                "test", headers);
        output.setValue(kafkaEntity);
        return request.createResponseBuilder(HttpStatus.OK).body("Message Sent, " + message).build();
    }*/
}
