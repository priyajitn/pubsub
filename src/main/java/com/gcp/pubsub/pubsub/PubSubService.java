package com.gcp.pubsub.pubsub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.spring.pubsub.PubSubAdmin;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;

@Service
public class PubSubService {
    private PubSubAdmin pubSubAdmin;

    @Autowired
    public PubSubService(PubSubAdmin pubSubAdmin) {
        this.pubSubAdmin = pubSubAdmin;
    }

    public Topic createTopicIfNotExists(String topicName) {
        Topic topic = pubSubAdmin.getTopic(topicName);
        if (topic == null) {
            topic = pubSubAdmin.createTopic(topicName);
            System.out.println("Topic created: " + topicName);
        } else {
            System.out.println("Topic already exists: " + topicName);
        }
        return topic;
    }

    public Subscription createSubscriptionIfNotExists(String subscriptionName, String topicName) {
        Subscription subscription = pubSubAdmin.getSubscription(subscriptionName);
        if (subscription == null) {
            subscription = pubSubAdmin.createSubscription(subscriptionName, topicName);
            System.out.println("Subscription created: " + subscriptionName);
        } else {
            System.out.println("Subscription already exists: " + subscriptionName);
        }
        return subscription;
    }

}
