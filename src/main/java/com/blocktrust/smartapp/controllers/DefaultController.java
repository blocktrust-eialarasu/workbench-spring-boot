package com.blocktrust.smartapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class DefaultController {

    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of("ping", "ping pong");
    }


    @GetMapping("/test-info-log")
    public String testInfoLog() {
        log.info("Test Info");
        return "Successfully logged 'Test Info'";
    }

    @GetMapping("/test-debug-log")
    public String testDebugLog() {
        log.debug("Test Debug");
        return "Successfully logged 'Test Debug'";
    }

    @GetMapping("/test-error-log")
    public String testErrorLog() {
        log.error("Test Error");
        return "Successfully logged 'Test Error'";
    }

}