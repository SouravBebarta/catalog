package com.omnirio.catalog.service;

import com.omnirio.catalog.dto.AttributeInfo;
import com.omnirio.catalog.dto.CategoryAttributeInfo;
import com.omnirio.catalog.dto.ProductInfo;
import com.omnirio.catalog.model.Category;
import com.omnirio.catalog.model.CategoryAttributes;
import com.omnirio.catalog.model.Product;
import com.omnirio.catalog.repository.CategoryAttributesRepository;
import com.omnirio.catalog.repository.CategoryRepository;
import com.omnirio.catalog.repository.ProductRepository;
import com.omnirio.catalog.utils.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("CatalogService")
@Transactional
public class CatalogService {

    @Autowired
    @Qualifier("CategoryRepository")
    private CategoryRepository categoryRepository;

    @Autowired
    @Qualifier("CategoryAttributesRepository")
    private CategoryAttributesRepository categoryAttributesRepository;

    @Autowired
    @Qualifier("ProductRepository")
    private ProductRepository productRepository;

    public int createCategory(String categoryName) {
        Category category = new Category();
        category.setName(categoryName);
        categoryRepository.save(category);
        return category.getId();
    }

    public void createCategoryAttributes(int categoryId, Map<String, Object> attributes) {
        Optional<Category> mayBeCategory = categoryRepository.findById(categoryId);
        if (mayBeCategory.isPresent()) {
            List<String> attributeList = (List) attributes.get(mayBeCategory.get().getName());
            attributeList.forEach(attrib -> {
                CategoryAttributes categoryAttribute = new CategoryAttributes();
                categoryAttribute.setCategory(mayBeCategory.get());
                categoryAttribute.setAttribute(attrib);
                categoryAttributesRepository.save(categoryAttribute);
            });
        }
    }

    public int createProduct(int categoryId, String productName, Map<String, Object> attributes) {
        Optional<Category> mayBeCategory = categoryRepository.findById(categoryId);
        if (mayBeCategory.isPresent()) {
            Product product = new Product();
            product.setCategory(mayBeCategory.get());
            product.setProductName(productName);
            product.setAttributes(attributes.toString());
            productRepository.save(product);
            return product.getId();
        }
        return 0;
    }

    public ProductInfo getProduct(int productId) {
        Optional<Product> mayBeProduct = productRepository.findById(productId);
        if (mayBeProduct.isPresent()) {
            Product product = mayBeProduct.get();
            ProductInfo prodInfo = new ProductInfo();
            prodInfo.setCategoryId(product.getCategory().getId());
            prodInfo.setCategoryName(product.getCategory().getName());
            prodInfo.setProductId(product.getId());
            prodInfo.setProductName(product.getProductName());
            Map<String, Object> map = MapUtils.convertStringToMap(product.getAttributes());
            prodInfo.setAttributes(map);
            return prodInfo;
        }
        return null;
    }

    public CategoryAttributeInfo getCategoryAttributes(int categoryId) {
        Optional<Category> mayBeCategory = categoryRepository.findById(categoryId);
        if (mayBeCategory.isPresent()) {
            List<CategoryAttributes> attributes = categoryAttributesRepository.findByCategory(mayBeCategory.get());
            List<AttributeInfo> attributeInfos = attributes.stream().map(attribute -> {
                return new AttributeInfo(attribute.getId(), attribute.getAttribute());
            }).collect(Collectors.toList());
            CategoryAttributeInfo categoryAttributeInfo = new CategoryAttributeInfo();
            categoryAttributeInfo.setCategoryId(categoryId);
            categoryAttributeInfo.setCategoryName(mayBeCategory.get().getName());
            categoryAttributeInfo.setAttributeInfos(attributeInfos);
            return categoryAttributeInfo;
        }
        return null;
    }

}
