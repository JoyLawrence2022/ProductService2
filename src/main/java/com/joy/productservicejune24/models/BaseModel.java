package com.joy.productservicejune24.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel{
    @Id  // sets id as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // sets PK to auto-increment
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
