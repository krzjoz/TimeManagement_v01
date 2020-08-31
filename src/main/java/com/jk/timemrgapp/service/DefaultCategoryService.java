package com.jk.timemrgapp.service;

import com.jk.timemrgapp.dto.entity.CategoryEntity;
import com.jk.timemrgapp.dto.repository.CategoryRepository;
import com.jk.timemrgapp.web.model.CategoryModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {

    private CategoryRepository categoryRepository;

    public DefaultCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryModel> findAll() {
        List resultList = categoryRepository.findAll();
        return resultList;
    }

    @Override
    public List<CategoryEntity> findAllByCategoryIdIsNot(int categoryId) {
        List resultList = categoryRepository.findAllByCategoryIdIsNot(categoryId);
        return resultList;
    }
}
