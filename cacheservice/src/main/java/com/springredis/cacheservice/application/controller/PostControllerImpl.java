package com.springredis.cacheservice.application.controller;

import java.util.List;

import com.springredis.cacheservice.application.service.PostService;
import com.springredis.cacheservice.domain.model.Post;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostControllerImpl implements PostController {

    PostService service;

    public PostControllerImpl(PostService service) {
        this.service = service;
    }

    @Override
    public Post addPost(Post post) {
        return (this.service.savePost(post) != null ) ? post : null;
    }

    @Override
    public Post getPostById(int id) {
        return this.service.findPostById(id);
    }

    @Override
    public List<Post> getTopPosts() {
        return this.service.findTopPosts(3);
    }
}