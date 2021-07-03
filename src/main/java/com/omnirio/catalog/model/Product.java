package com.omnirio.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Map;

@Setter
@Getter
@Entity
@Table(name = "tblproduct")
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tblproduct_cid_gen")
    @SequenceGenerator(name = "tblproduct_cid_gen", sequenceName = "tblproduct_cid_seq", allocationSize = 1)
    private int id;

    private String productName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private String attributes;
}
