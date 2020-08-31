package com.jk.timemrgapp.service;

import com.jk.timemrgapp.web.model.TaskModel;

import java.util.List;

public interface TaskService {
    TaskModel save(TaskModel taskModel);
    List<TaskModel> findAll();
    List<TaskModel> findAllByUserUserId(Long userId);
    List<TaskModel> findByUserStatusCategory(Long userId, Integer statusId, Integer categoryId);
    List<TaskModel> findByUsernameStatusCategory(String username, Integer statusId, Integer categoryId);
    List<TaskModel> findAllByUserUsername(String username);
    List<TaskModel> findAllByStatusAndCategory(Integer statusId, Integer categoryId);
    TaskModel findByTaskId(Long taskId);
    void deleteById(Long taskId);
}
