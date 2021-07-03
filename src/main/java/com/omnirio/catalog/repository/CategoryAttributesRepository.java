package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.CategoryAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("CategoryAttributesRepository")
public interface CategoryAttributesRepository extends JpaRepository<CategoryAttributes, Integer> {

    List<CategoryAttributes> findByCategory(Category category);
}
