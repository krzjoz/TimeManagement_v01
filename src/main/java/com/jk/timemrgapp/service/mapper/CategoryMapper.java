package com.jk.timemrgapp.service.mapper;

import com.jk.timemrgapp.dto.entity.CategoryEntity;
import com.jk.timemrgapp.web.model.CategoryModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryEntity toCategoryEntity(CategoryModel categoryModel){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoryModel, CategoryEntity.class);
    }

    public CategoryModel fromCategoryEntity(CategoryEntity categoryEntity){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(categoryEntity, CategoryModel.class);
    }
}
