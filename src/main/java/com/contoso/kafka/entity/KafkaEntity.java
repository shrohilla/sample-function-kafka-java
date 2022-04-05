package com.contoso.kafka.entity;

import java.util.Arrays;

public class KafkaEntity {
    private int offSet;
    private int partition;
    private  String topic;
    private String timeStamp;
    private String value;
    private Header[] headers;

    public KafkaEntity() {

    }

    public KafkaEntity(int offSet, int partition, String topic, String timeStamp, String value, Header[] headers) {
        this.offSet = offSet;
        this.partition = partition;
        this.topic = topic;
        this.timeStamp = timeStamp;
        this.value = value;
        this.headers = headers;
    }

    public int getOffSet() {
        return offSet;
    }

    public int getPartition() {
        return partition;
    }

    public String getTopic() {
        return topic;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getValue() {
        return value;
    }

    public Header[] getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "KafkaEntity{" +
                "offSet=" + offSet +
                ", partition=" + partition +
                ", topic='" + topic + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                ", value='" + value + '\'' +
                ", headers=" + Arrays.toString(headers) +
                '}';
    }

    public void setOffSet(int offSet) {
        this.offSet = offSet;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setHeaders(Header[] headers) {
        this.headers = headers;
    }
}
