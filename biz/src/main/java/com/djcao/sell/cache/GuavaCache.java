package com.djcao.sell.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/3/18
 */
public class GuavaCache {

    @Test
    public void testCache() throws ExecutionException {
        Cache<Object, Object> build = CacheBuilder.newBuilder().maximumSize(100).build();
        build.put(1,2);
        System.out.println(build.getIfPresent(1));
    }
}
