package com.omnirio.catalog.service;

import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("CatalogService")
@Transactional
public class CatalogService {

    @Autowired
    @Qualifier("CatalogRepository")
    private CatalogRepository catalogRepository;

    public void createCategory (String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        catalogRepository.save(category);
    }
}
