package com.omnirio.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tblcategory_attributes")
@NoArgsConstructor
@AllArgsConstructor
public class CategoryAttributes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tblcategory_attributes_cid_gen")
    @SequenceGenerator(name = "tblcategory_attributes_cid_gen", sequenceName = "tblcategory_attributes_cid_seq", allocationSize = 1)
    private int id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String attribute;
}
