package com.GoLink.services.Impl;

import com.GoLink.repository.HiDomainRepository;
import com.GoLink.services.HiDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiDomainServiceImpl implements HiDomainService {
    @Autowired
    private HiDomainRepository hiDomainRepository;

    @Override
    public String sayHi(String message) {
        return hiDomainRepository.sayHi(message);
    }
}
