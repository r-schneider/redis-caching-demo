package com.springredis.cacheservice.application.controller;

import java.util.List;

import com.springredis.cacheservice.domain.model.Post;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/posts", produces = MediaType.APPLICATION_JSON_VALUE)
public interface PostController {
    
    @GetMapping(value = "/add")
    Post addPost(@RequestBody Post post); 

    @Cacheable(value = "single-post", key = "#id")
    @GetMapping(value = "/{id}")
    Post getPostById(@PathVariable String id); 

    @Cacheable(value = "top-posts")
    @GetMapping(value = "/likedposts")
    List<Post> getTopPosts(); 
}