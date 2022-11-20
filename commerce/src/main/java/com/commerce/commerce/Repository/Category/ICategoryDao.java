package com.commerce.commerce.Repository.Category;

import com.commerce.commerce.Entity.Category;

import com.commerce.commerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ICategoryDao extends JpaRepository<Category,Long> {
    Category findByCategoryName(String categoryName);


    @Transactional
    @Modifying
    @Query("update Category c set c.categoryName = ?1")
    int updateCategoryNameBy(String categoryName);










}
