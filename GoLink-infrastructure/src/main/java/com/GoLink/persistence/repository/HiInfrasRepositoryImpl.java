package com.GoLink.persistence.repository;

import com.GoLink.repository.HiDomainRepository;

public class HiInfrasRepositoryImpl implements HiDomainRepository {
    @Override
    public String sayHi(String message) {
        return "sayhi";
    }
}
