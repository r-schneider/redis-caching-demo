package com.springredis.cacheservice.domain.repository;

import java.util.List;
import java.util.Optional;

import com.springredis.cacheservice.domain.model.Post;

public interface PostRepository {

    Post save(Post post);

    Optional<Post> findById(int id);

    List<Post> findAll();
}