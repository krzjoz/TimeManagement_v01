package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.entity.TaskEntity;
import com.jk.timemrgapp.dto.repository.TaskRepository;
import com.jk.timemrgapp.service.mapper.TaskMapper;
import com.jk.timemrgapp.web.model.TaskModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultTaskService implements TaskService {

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;

    public DefaultTaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public TaskModel save(TaskModel taskModel) {
        TaskEntity taskEntity = taskMapper.toTaskEntity(taskModel);
        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        return taskMapper.fromTaskEntity(savedTaskEntity);
    }

    @Override
    public List<TaskModel> findAll() {
        List resultList = taskRepository.findAll();
        return resultList;
    }

    @Override
    public List<TaskModel> findAllByUserUserId(Long userId) {
        List resultList = taskRepository.findAllByUserUserId(userId);
        return resultList;
    }

    @Override
    public List<TaskModel> findByUserStatusCategory(Long userId, Integer statusId, Integer categoryId) {
        List result = taskRepository.findAllByUserUserIdAndStatusIdStatusIdAndCategoryIdCategoryId(userId, statusId, categoryId);
        return result;
    }

    @Override
    public List<TaskModel> findByUsernameStatusCategory(String username, Integer statusId, Integer categoryId) {
        List resultList = taskRepository.findAllByUserUsernameAndStatusIdStatusIdAndCategoryIdCategoryId(username, statusId, categoryId);
        return null;
    }

    @Override
    public List<TaskModel> findAllByUserUsername(String username) {
        List resultList = taskRepository.findAllByUserUsername(username);
        return resultList;
    }

    @Override
    public List<TaskModel> findAllByStatusAndCategory(Integer statusId, Integer categoryId) {
        List resultList = taskRepository.findAllByStatusIdStatusIdAndCategoryIdCategoryId(statusId, categoryId);
        return resultList;
    }

    @Override
    public TaskModel findByTaskId(Long taskId) {
        TaskEntity taskEntity = taskRepository.findByTaskId(taskId);
        return taskMapper.fromTaskEntity(taskEntity);
    }

    @Override
    public void deleteById(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
