package com.springredis.cacheservice.domain.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.springredis.cacheservice.domain.model.Post;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class PostRepository {
    
    List<Post> posts = new ArrayList<>();

    @PostConstruct
    public void initData() {
        var initialPosts = Arrays.asList(
            new Post(1, "First Post", "This is my first blog entry so...", "Unknown", 143),
            new Post(2, "Second Post", "Ok, so i decided to write again and...", "Unknown", 350),
            new Post(3, "Third Post", "Three times in a row? wow...", "Unknown", 678),
            new Post(4, "Fourth Post", "I'm thinking about ending this blog soon...", "Unknown", 290),
            new Post(5, "Fifth Post", "Goodbye and thanks...", "Unknown", 920)
        );
        for (Post post :initialPosts) {
            posts.add(post);
        }
            log.info("Lista: {}", posts);
    }
    
    public Post save(Post post) {
        simulateSlowService();
        posts.add(post);
        return post;
    }

    public Optional<Post> findById(int id) {
        simulateSlowService();
        Optional<Post> postById = null;
        for (Post post : posts) {
            if (id == post.getId()) { 
                postById = Optional.of(post);
            } 
        }
        return postById;    
    }
    
    public List<Post> findAll() {
        simulateSlowService();
        return posts;
    }

    private void simulateSlowService() {
        try {
          Thread.sleep(3000L);
          System.out.println("REQUESTING FROM DB");
        } catch (InterruptedException e) {
          throw new IllegalStateException(e);
        }
    }
}