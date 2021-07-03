package com.omnirio.catalog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "tblcategory")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "tblcategory_cid_gen")
    @SequenceGenerator(name = "tblcategory_cid_gen", sequenceName = "tblcategory_cid_seq", allocationSize = 1)
    private int id;

    private String name;
}
