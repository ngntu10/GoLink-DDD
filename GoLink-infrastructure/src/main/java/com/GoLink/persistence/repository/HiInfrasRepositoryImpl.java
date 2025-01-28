package com.GoLink.persistence.repository;

import com.GoLink.repository.HiDomainRepository;
import org.springframework.stereotype.Service;

@Service
public class HiInfrasRepositoryImpl implements HiDomainRepository {
    @Override
    public String sayHi(String message) {
        return "sayhi";
    }
}
