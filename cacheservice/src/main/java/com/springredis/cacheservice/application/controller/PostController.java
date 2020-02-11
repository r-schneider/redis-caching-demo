package com.springredis.cacheservice.application.controller;

import java.util.List;

import com.springredis.cacheservice.domain.model.Post;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public interface PostController {
    
    @PostMapping(value = "/add")
    Post addPost(@RequestBody Post post); 

    @GetMapping(value = "/{id}")
    Post getPostById(@PathVariable int id); 

    @GetMapping("/liked")
    List<Post> getTopPosts(); 
}