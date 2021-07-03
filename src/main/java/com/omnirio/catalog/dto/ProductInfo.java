package com.omnirio.catalog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class ProductInfo {

    private int productId;

    private String productName;

    private int categoryId;

    private String categoryName;

    private Map<String, Object> attributes;

}
