package com.contoso.kafka;

import com.contoso.kafka.entity.Header;
import com.contoso.kafka.entity.KafkaEntity;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import io.confluent.examples.clients.basicavro.Payment;
//import io.confluent.examples.clients.basicavro.Payment;

/**
 * Azure Functions with HTTP Trigger.
 */
public class TriggerFunction {

    private static final String schema = "{\"type\":\"record\",\"name\":\"Payment\",\"namespace\":\"io.confluent.examples.clients.basicavro\",\"fields\":[{\"name\":\"id\",\"type\":\"string\"},{\"name\":\"amount\",\"type\":\"double\"},{\"name\":\"type\",\"type\":\"string\"}]}";

    private static final String trigName = "testTriggerAvro";
    /**
     * This function consume KafkaEvents on the localhost. Change the topic, brokerList, and consumerGroup to fit your enviornment.
     * The function is trigged one for each KafkaEvent
     * @param kafkaEventData
     * @param context
     */
    @FunctionName("TestTrigger")
    public void runAvro(
            @KafkaTrigger(name = trigName,
                          topic = "topicavro",
                          brokerList = "BrokerList",
                          username = "$ConnectionString",
                          password = "%KafkaPassword%",
                    // avroSchema = schema,
                          authenticationMode = BrokerAuthenticationMode.PLAIN,
                          protocol = BrokerProtocol.SASLSSL,
                          consumerGroup="$Default") Payment kafkaEventData,
            final ExecutionContext context) {
        context.getLogger().info(kafkaEventData.toString());
    }

    @FunctionName("TestTriggerNew")
    public void runTriggerMany(
            @KafkaTrigger(name = "testTriggerNew",
                    topic = "topic",
                    brokerList = "BrokerList",
                    username = "$ConnectionString",
                    password = "%KafkaPassword%",
                    authenticationMode = BrokerAuthenticationMode.PLAIN,
                    protocol = BrokerProtocol.SASLSSL,
                    cardinality = Cardinality.MANY,
                    dataType = "string",
                    consumerGroup="$Default") String[] kafkaEventDataArr,
            final ExecutionContext context) {
        for(String  kafkaEventData: kafkaEventDataArr) {
            context.getLogger().info(kafkaEventData.toString());
        }
    }


}
