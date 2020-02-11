package com.springredis.cacheservice.domain.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String title;
    private String content;
    private String author;
    private int likes;
}