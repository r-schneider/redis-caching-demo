package com.springredis.cacheservice.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Author implements Serializable{

    private static final long serialVersionUID = 9163514275584770683L;
    private String name;
}