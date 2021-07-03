package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("CatalogRepository")
public interface CatalogRepository extends JpaRepository<Category,Integer> {

}
