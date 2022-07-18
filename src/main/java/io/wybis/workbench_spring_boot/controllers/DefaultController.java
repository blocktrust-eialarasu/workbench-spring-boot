package io.wybis.workbench_spring_boot.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@RestController
public class DefaultController {

    @Resource
    private Environment environment;

    @Value("app.name")
    String appName;

    @GetMapping("/ping")
    public Map<String, String> ping() {
        return Map.of("ping", "ping pong");
    }

    @GetMapping("/app-info")
    public Map<String, Object> appInfo() {
        Map<String, Object> appInfo = Map.of(
                "mode", Arrays.asList(environment.getActiveProfiles()).stream(),
                "name", appName
        );
        return appInfo;
    }

    @GetMapping("/test-log")
    public Map<String, Object> testLog() {
        log.error("Test error log...");
        log.warn("Test warn log...");
        log.info("Test info log...");
        log.debug("Test debug log...");
        log.trace("Test trace log...");
        return Map.of("message", "Successfully added test logs");
    }
}