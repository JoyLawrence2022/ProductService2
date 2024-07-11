package com.joy.productservicejune24.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//Note that there has to be a correct one to one mapping between the attributes here and
//the values that will be returned by FakeStore
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
