package com.omnirio.catalog.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CategoryAttributeInfo {

    private int categoryId;

    private String categoryName;

    private List<AttributeInfo> attributeInfos;

}
