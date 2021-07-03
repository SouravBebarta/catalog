package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("CategoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
