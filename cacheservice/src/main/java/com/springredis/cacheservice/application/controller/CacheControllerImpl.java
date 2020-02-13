package com.springredis.cacheservice.application.controller;

import com.springredis.cacheservice.application.service.CacheService;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class CacheControllerImpl implements CacheController {

    CacheService service;
    
    public CacheControllerImpl(CacheService service) {
        this.service = service;
    }

    @Override
    public void clearAllCaches() {
        this.service.evictAllCaches();
    }
}
    