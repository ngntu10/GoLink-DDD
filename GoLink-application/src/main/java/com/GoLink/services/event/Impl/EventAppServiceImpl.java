package com.GoLink.services.event.Impl;

import com.GoLink.services.event.EventAppService;
import org.springframework.stereotype.Service;

@Service
public class EventAppServiceImpl implements EventAppService {
    @Override
    public String sayHi(String name) {
        return "Hello " + name;
    }
}
