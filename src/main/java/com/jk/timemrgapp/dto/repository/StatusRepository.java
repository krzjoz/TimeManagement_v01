package com.jk.timemrgapp.dto.repository;

import com.jk.timemrgapp.dto.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Integer> {
    List<StatusEntity> findAllByStatusIdIsNot(int statusId);
}
