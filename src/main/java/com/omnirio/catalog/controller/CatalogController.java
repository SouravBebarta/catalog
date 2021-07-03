package com.omnirio.catalog.controller;

import com.omnirio.catalog.dto.CategoryAttributeInfo;
import com.omnirio.catalog.dto.ProductInfo;
import com.omnirio.catalog.service.CatalogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController("CatalogController")
@RequestMapping("/v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;


    @PostMapping("/category/{categoryName}")
    @ApiOperation(value = "Create category", produces = "application/json")
    public int createCategory(@ApiParam(value = "categoryName", required = true) @PathVariable("categoryName") String categoryName) {
        return catalogService.createCategory(categoryName);
    }

    @PostMapping("/categoryAttribute/{categoryId}")
    @ApiOperation(value = "Create attributes for a category", produces = "application/json")
    public void createCategoryAttributes(@RequestBody Map<String, Object> attributesMap, @ApiParam(value = "categoryId", required = true) @PathVariable("categoryId") int categoryId) {
        catalogService.createCategoryAttributes(categoryId, attributesMap);
    }


    @PostMapping("/product/{categoryId}/{productName}")
    @ApiOperation(value = "Create product", produces = "application/json")
    public int createProduct(@RequestBody Map<String, Object> attributesMap, @ApiParam(value = "categoryId", required = true) @PathVariable("categoryId") int categoryId, @ApiParam(value = "productName", required = true) @PathVariable("productName") String productName) {
        return catalogService.createProduct(categoryId, productName, attributesMap);
    }

    @GetMapping("/product/{productId}")
    @ApiOperation(value = "Get product by product id", produces = "application/json")
    public ProductInfo getProduct(@ApiParam(value = "productId", required = true) @PathVariable("productId") int productId) {
        return catalogService.getProduct(productId);
    }

    @GetMapping("/categoryAttribute/{categoryId}")
    @ApiOperation(value = "Get category attributes by category id", produces = "application/json")
    public CategoryAttributeInfo getCategoryAttributes(@ApiParam(value = "categoryId", required = true) @PathVariable("categoryId") int categoryId) {
        return catalogService.getCategoryAttributes(categoryId);
    }
}
