package com.springredis.cacheservice.application.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.springredis.cacheservice.domain.model.Post;
import com.springredis.cacheservice.domain.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;


public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public Post savePost(Post post) {
        return repository.save(post);
    }

    @Override
    public Post findPostById(String id) {
        var post = repository.findById(id);
        return (post.isPresent()) ? post.get() : null;
    }

    @Override
    public List<Post> findTopPosts(int maxPosts) {
        var allPosts = (List<Post>) repository.findAll();
        var postsByLikes = allPosts.stream().sorted(Comparator.comparingInt(Post::getLikes).reversed()).collect(Collectors.toList());
        var topPosts = postsByLikes.stream().limit(maxPosts).collect(Collectors.toList());
        return topPosts;
    }
}