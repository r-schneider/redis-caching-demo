package com.springredis.cacheservice.application.service;

import java.util.List;

import com.springredis.cacheservice.domain.model.Post;

public interface PostService {

    Post savePost(Post post);

    Post findPostById(int id);

    List<Post> findTopPosts(int maxPosts);
}