package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.entity.StatusEntity;
import com.jk.timemrgapp.dto.repository.StatusRepository;
import com.jk.timemrgapp.web.model.StatusModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultStatusService implements StatusService {

    private StatusRepository statusRepository;

    public DefaultStatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<StatusModel> findAll() {
        List resultList = statusRepository.findAll();
        return resultList;
    }

    @Override
    public List<StatusEntity> findAllByStatusIdIsNot(int statusId) {
        List resultList = statusRepository.findAllByStatusIdIsNot(statusId);
        return resultList;
    }
}
