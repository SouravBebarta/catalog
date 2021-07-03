package com.omnirio.catalog.repository;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("ProductRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
