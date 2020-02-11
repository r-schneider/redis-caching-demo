package com.springredis.cacheservice.application.service;

import java.util.List;

import com.springredis.cacheservice.domain.model.Post;

import org.springframework.stereotype.Service;

@Service
public interface PostService {

    Post savePost(Post post);
    Post findPostById(String id);
    List<Post> findTopPosts(int maxPosts);
}