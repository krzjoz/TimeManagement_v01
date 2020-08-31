package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.entity.StatusEntity;
import com.jk.timemrgapp.web.model.StatusModel;

import java.util.List;

public interface StatusService {
    List<StatusModel> findAll();
    List<StatusEntity> findAllByStatusIdIsNot(int statusId);

}
