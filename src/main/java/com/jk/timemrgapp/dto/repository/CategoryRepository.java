package com.jk.timemrgapp.dto.repository;

import com.jk.timemrgapp.dto.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
    List<CategoryEntity> findAllByCategoryIdIsNot(int categoryId);
}
