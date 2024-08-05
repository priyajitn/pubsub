package com.gcp.pubsub.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PubSubInitializer implements CommandLineRunner {

    @Autowired
    private PubSubService pubSubService;
    @Value("${gcp.pubsub.topic}")
    String topicName;
    @Value("${gcp.pubsub.subscription}")
    String subscriptionName;

    @Override
    public void run(String... args) {
        pubSubService.createTopicIfNotExists(topicName);
        pubSubService.createSubscriptionIfNotExists(subscriptionName, topicName);
    }
}