package com.jk.timemrgapp.service;

import com.jk.timemrgapp.web.model.AuthorityModel;

import java.util.List;

public interface AuthorityService {
    List<AuthorityModel> findAll();
}
