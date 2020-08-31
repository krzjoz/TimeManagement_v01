package com.jk.timemrgapp.service.mapper;

import com.jk.timemrgapp.dto.entity.security.UserEntity;
import com.jk.timemrgapp.web.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(UserModel userModel){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userModel, UserEntity.class);
    }

    public UserModel fromUserEntity(UserEntity userEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userEntity, UserModel.class);
    }

}
