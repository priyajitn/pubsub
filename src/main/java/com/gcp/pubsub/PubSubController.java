package com.gcp.pubsub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PubSubController {

    @GetMapping
    public String getResponse() {
        return "hello world";
    }
}
