package com.example.trendviewv1.study.spring.greeting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "%s님, 트렌드뷰에 오신 것을 환영합니다.";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "익명의 사용자") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
