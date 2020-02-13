package com.springredis.cacheservice.application.service;

import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class CacheServiceImpl implements CacheService {

    CacheManager manager;

    public CacheServiceImpl(CacheManager manager) {
        this.manager = manager;
    }

    @Override
    public void evictAllCaches() {
        manager.getCacheNames().stream()
          .forEach(cacheName -> manager.getCache(cacheName).clear());
    }
}