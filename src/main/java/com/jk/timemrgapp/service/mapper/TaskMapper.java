package com.jk.timemrgapp.service.mapper;

import com.jk.timemrgapp.dto.entity.TaskEntity;
import com.jk.timemrgapp.web.model.TaskModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskMapper {

    public TaskEntity toTaskEntity(TaskModel taskModel){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        TaskEntity taskEntity =  modelMapper.map(taskModel, TaskEntity.class);
        taskEntity.setTaskFromDate(LocalDateTime.parse(taskModel.getTaskFromDate()));
        taskEntity.setTaskToDate(LocalDateTime.parse(taskModel.getTaskToDate()));
        return taskEntity;
    }

    public TaskModel fromTaskEntity(TaskEntity taskEntity){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(taskEntity, TaskModel.class);
    }
}
