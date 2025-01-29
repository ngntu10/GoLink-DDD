package com.GoLink.controller.resource;

import com.GoLink.services.event.EventAppService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hello")
public class HiController {
    @Autowired
    private EventAppService eventAppService;

    @Autowired
    private RestTemplate restTemplate;
    
    @RateLimiter(name = "backendA", fallbackMethod = "fallbackHello")
    @GetMapping("hi")
    public String hello() {
        return eventAppService.sayHi("Tu");
    }
    
    public String fallbackHello(Throwable throwable) {
        return "Too many requests";
    }

    @RateLimiter(name = "backendB", fallbackMethod = "fallbackHello")
    @GetMapping("hi/v2")
    public String helloV2() {
        return eventAppService.sayHi("ICPC");
    }

    @GetMapping("circuit/breaker")
    public String circuit() {
       return null;
    }
}
