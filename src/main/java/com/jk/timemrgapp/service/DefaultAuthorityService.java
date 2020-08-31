package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.repository.security.AuthorityRepository;
import com.jk.timemrgapp.web.model.AuthorityModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAuthorityService implements AuthorityService{

    private AuthorityRepository authorityRepository;

    @Autowired
    public DefaultAuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    @Override
    public List<AuthorityModel> findAll() {
        List resultList = authorityRepository.findAll();
        return resultList;
    }
}
