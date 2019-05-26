package com.djcao.sell.cache;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.PersistentCacheManager;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.ResourcePools;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.CacheManagerConfiguration;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.expiry.Duration;
import org.ehcache.expiry.Expirations;
import org.ehcache.xml.model.ResourceUnit;
import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/18
 */
public class Ehcache {
    @Test
    public void testHeapCache(){
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
        ResourcePoolsBuilder heap = ResourcePoolsBuilder.heap(10);
        CacheConfigurationBuilder<Integer, Object> integerStringCacheConfigurationBuilder = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(Integer.class, Object.class, heap);
        Cache<Integer, Object> testHeapCache = cacheManager.createCache("testHeapCache",
            integerStringCacheConfigurationBuilder);
        testHeapCache.put(1,"2");
        System.out.println(testHeapCache.get(1));
    }

    @Test
    public void testOffHeapCache(){
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().build();
        cacheManager.init();
        ResourcePoolsBuilder offheap = ResourcePoolsBuilder.newResourcePoolsBuilder().offheap(10, MemoryUnit.MB);
        CacheConfigurationBuilder<Integer, String> integerObjectCacheConfigurationBuilder = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(Integer.class, String.class, offheap);
        Cache<Integer, String> testOffHeapCache = cacheManager.createCache("testOffHeapCache",
            integerObjectCacheConfigurationBuilder);
        testOffHeapCache.put(1,"3");
        System.out.println(testOffHeapCache.get(1));
    }

    @Test
    public void testDiskCache() throws InterruptedException {
        CacheManagerConfiguration<PersistentCacheManager> persistence = CacheManagerBuilder.persistence(
            new File("C:", "disk.txt"));
        PersistentCacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().with(persistence).build();
        cacheManager.init();
        ResourcePoolsBuilder resourcePoolsBuilder = ResourcePoolsBuilder.newResourcePoolsBuilder().disk(10, MemoryUnit.MB,true);

        CacheConfigurationBuilder<Integer, String> integerStringCacheConfigurationBuilder = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(Integer.class, String.class, resourcePoolsBuilder);
        Cache<Integer, String> testDiskCache = cacheManager.createCache("testDiskCache",
            integerStringCacheConfigurationBuilder);
        testDiskCache.put(1,"4");
        System.out.println(testDiskCache.get(1));
        Thread.sleep(3000);
    }

    @Test
    public void test3LevelCache(){
        CacheManagerConfiguration<PersistentCacheManager> persistence = CacheManagerBuilder.persistence(
            new File("C:/3LevelDisk"));
        PersistentCacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder().with(persistence).build();
        cacheManager.init();
        ResourcePoolsBuilder disk = ResourcePoolsBuilder.newResourcePoolsBuilder().heap(10, MemoryUnit.MB)
            .offheap(100, MemoryUnit.MB)
            .disk(1000, MemoryUnit.MB);
        CacheConfiguration<Integer, String> integerStringCacheConfiguration = CacheConfigurationBuilder
            .newCacheConfigurationBuilder(Integer.class, String.class, disk).withExpiry(Expirations.timeToIdleExpiration(
                Duration.of(20, TimeUnit.SECONDS))).build();
        Cache<Integer, String> test3LevelCache = cacheManager.createCache("test3LevelCache",
            integerStringCacheConfiguration);
        test3LevelCache.put(1,"5");
        System.out.println(test3LevelCache.get(1));

    }
}
