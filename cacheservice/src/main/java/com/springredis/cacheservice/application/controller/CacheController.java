package com.springredis.cacheservice.application.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(path = "/posts/cache")
public interface CacheController {

    @GetMapping(value = "/clearall")
    void clearAllCaches();
}