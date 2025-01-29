package com.GoLink.controller.resource;

import com.GoLink.services.event.EventAppService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.yaml.snakeyaml.events.Event;

import java.security.SecureRandom;

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

    private static final SecureRandom secureRandom = new SecureRandom();
    @GetMapping("circuit/breaker")
    @CircuitBreaker(name = "default", fallbackMethod = "fallbackCircuitBreaker")
    public String circuit() {
        int productId = secureRandom.nextInt(20) + 1;
        String url = "https://fakestoreapi.com/products/" + productId;
        return restTemplate.getForObject(url, String.class);
    }
    
    public String fallbackCircuitBreaker(Throwable throwable) {
        return "Service unavailable";
    }
}
