package com.gcp.pubsub.pubsub;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.cloud.spring.pubsub.core.PubSubTemplate;

@Service
public class PubSubPublisherService {
    @Value("${gcp.pubsub.topic}")
    private String topicName;

    private final PubSubTemplate pubSubTemplate;

    @Autowired
    public PubSubPublisherService(PubSubTemplate pubSubTemplate) {
        this.pubSubTemplate = pubSubTemplate;
    }

    public void publishMessage(String message, String pattern) {
        Map<String, String> headers = new HashMap<>();
        headers.put("pattern", pattern);
        // published message
        this.pubSubTemplate.publish(topicName, message, headers);
    }

}
