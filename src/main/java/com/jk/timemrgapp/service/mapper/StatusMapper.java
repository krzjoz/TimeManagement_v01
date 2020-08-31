package com.jk.timemrgapp.service.mapper;

import com.jk.timemrgapp.dto.entity.StatusEntity;
import com.jk.timemrgapp.web.model.StatusModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public StatusEntity toStatusEntity(StatusModel statusModel){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(statusModel, StatusEntity.class);
    }

    public StatusModel fromStatusEntity(StatusEntity statusEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(statusEntity, StatusModel.class);
    }

}
