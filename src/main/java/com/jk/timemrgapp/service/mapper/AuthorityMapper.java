package com.jk.timemrgapp.service.mapper;

import com.jk.timemrgapp.dto.entity.security.AuthorityEntity;
import com.jk.timemrgapp.web.model.AuthorityModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthorityMapper {

    public AuthorityEntity toAuthorityEntity(AuthorityModel authorityModel){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(authorityModel, AuthorityEntity.class);
    }

    public AuthorityModel fromAuthorityEntity(AuthorityEntity authorityEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(authorityEntity, AuthorityModel.class);
    }

}
