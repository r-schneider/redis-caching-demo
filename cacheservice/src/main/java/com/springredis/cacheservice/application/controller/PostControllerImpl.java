package com.springredis.cacheservice.application.controller;

import java.util.List;

import com.springredis.cacheservice.application.service.PostServiceImpl;
import com.springredis.cacheservice.domain.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerImpl implements PostController {

    @Autowired
    PostServiceImpl service;

    public PostControllerImpl(PostServiceImpl service) {
        this.service = service;
    }

    @Override
    public Post addPost(Post post) {
        return service.savePost(post);
    }

    @Override
    public Post getPostById(String id) {
        return service.findPostById(id);
    }

    @Override
    public List<Post> getTopPosts() {
        return service.findTopPosts(5);
    }

}