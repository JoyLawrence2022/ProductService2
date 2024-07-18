package com.joy.productservicejune24.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
//    private long id;
    private String title;
    private double price;
    @ManyToOne
    private Category category;
}
