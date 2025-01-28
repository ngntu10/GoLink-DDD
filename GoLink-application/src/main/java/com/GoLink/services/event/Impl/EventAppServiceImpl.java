package com.GoLink.services.event.Impl;

import com.GoLink.services.HiDomainService;
import com.GoLink.services.event.EventAppService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class EventAppServiceImpl implements EventAppService {
    
    // Call domain service
    @Resource
    private HiDomainService hiDomainService;
    
    @Override
    public String sayHi(String name) {
        return hiDomainService.sayHi(name);
    }
}
