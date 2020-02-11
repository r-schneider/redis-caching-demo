package com.springredis.cacheservice.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.springredis.cacheservice.domain.model.Post;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, String> {
    
    List<Post> posts = new ArrayList<>();
    
    @PostConstruct
    public static void init() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post("1", "First Post", "This is my first blog entry so...", "Unknown", 143));
        posts.add(new Post("2", "Second Post", "Ok, so i decided to write again and...", "Unknown", 350));
        posts.add(new Post("3", "Third Post", "Three times in a row? wow...", "Unknown", 678));
        posts.add(new Post("4", "Fourth Post", "I'm thinking about ending this blog soon...", "Unknown", 290));
        posts.add(new Post("5", "Fifth Post", "Goodbye and thanks...", "Unknown", 920));
    }

    @Override
    default <S extends Post> S save(S entity) {
        simulateSlowService();
        System.out.println("SAVE POST - DATABASE");
        posts.add(entity);
        return entity;
    }

    @Override
    default Optional<Post> findById(String id) {
        simulateSlowService();
        System.out.println("GET POST BY ID - DATABASE");
        Optional<Post> postById = null;
        for (Post post : posts) {
            if (id == post.getId()) { 
                postById = Optional.of(post);
            } 
        }
        return postById;
    }

    default Iterable<Post> findAll() {
        simulateSlowService();
        System.out.println("GET ALL POSTS - DATABASE");
        return posts;
    }

    private void simulateSlowService() {
        try {
          long time = 3000L;
          Thread.sleep(time);
        } catch (InterruptedException e) {
          throw new IllegalStateException(e);
        }
      }
       
    
}