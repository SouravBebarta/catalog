package com.omnirio.catalog.controller;

import com.omnirio.catalog.service.CatalogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController("CatalogController")
@RequestMapping("/v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;


    @PostMapping("/category/{categoryName}")
    @ApiOperation(value = "Create category", produces = "application/json")
    public void createCategory(@ApiParam(value = "categoryName", required = true) @PathVariable("categoryName") String categoryName) {
        catalogService.createCategory(categoryName);
    }
}
