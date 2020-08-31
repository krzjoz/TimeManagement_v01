package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.entity.CategoryEntity;
import com.jk.timemrgapp.web.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<CategoryModel> findAll();
    List<CategoryEntity> findAllByCategoryIdIsNot(int categoryId);
}
