package com.springredis.cacheservice.application.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.springredis.cacheservice.domain.model.Post;
import com.springredis.cacheservice.domain.repository.PostRepository;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    PostRepository repository;

    CacheManager cacheManager;

    public PostServiceImpl(PostRepository repository, CacheManager cacheManager) {
        this.repository = repository;
        this.cacheManager = cacheManager;
    }

    @Override
    @CacheEvict(value = "top-posts", allEntries = true)
    public Post savePost(Post post) {
        return (isValid(post)) ? this.repository.save(post) : null;
    }

    @Override
    @Cacheable(cacheNames = "post", key = "#id")
    public Post findPostById(int id) {
        var post = this.repository.findById(id);
        return (post.isPresent()) ? post.get() : null;
    }

    @Override
    @Cacheable(cacheNames = "top-posts", key = "#root.method.name")
    public List<Post> findTopPosts(int maxPosts) {
        var allPosts = (List<Post>) this.repository.findAll();
        var topPosts = allPosts.stream().sorted(Comparator.comparingInt(Post::getLikes).reversed()).limit(maxPosts)
                .collect(Collectors.toList());
        return topPosts;
    }

    @Override
    public Boolean isValid(Post newEntry) {
        var post = this.repository.findById(newEntry.getId());
        return (post.isPresent()) ? false : true;
    }
}