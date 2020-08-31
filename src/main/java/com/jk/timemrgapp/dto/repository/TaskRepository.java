package com.jk.timemrgapp.dto.repository;

import com.jk.timemrgapp.dto.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    List<TaskEntity> findAllByUserUserId(Long userId);
    List<TaskEntity> findAllByUserUserIdAndStatusIdStatusIdAndCategoryIdCategoryId(Long userId, Integer statusId, Integer categoryId);
    List<TaskEntity> findAllByStatusIdStatusIdAndCategoryIdCategoryId(Integer statusId, Integer categoryId);
    List<TaskEntity> findAllByUserUsernameAndStatusIdStatusIdAndCategoryIdCategoryId(String username, Integer statusId, Integer categoryId);
    List<TaskEntity> findAllByUserUsername(String username);
    TaskEntity findByTaskId(Long taskId);
    void deleteById(Long taskId);
}
