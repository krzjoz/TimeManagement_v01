package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.entity.security.UserEntity;
import com.jk.timemrgapp.dto.repository.security.UserRepository;
import com.jk.timemrgapp.service.mapper.UserMapper;
import com.jk.timemrgapp.web.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DefaultUserService implements UserService{

    private UserRepository userRepository;
    private UserMapper userMapper;

    @Autowired
    public DefaultUserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserModel save(UserModel userModel) {
        UserEntity userEntity = userMapper.toUserEntity(userModel);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return userMapper.fromUserEntity(savedUserEntity);
    }

    @Override
    public Long findUserIdByUsername(String username) {
        return userRepository.findUserIdByUsername(username);
    }

}
