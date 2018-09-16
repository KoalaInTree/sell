package com.djcao.sell.design.singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *懒汉式单例--这种初始化性能好，懒汉式单例可以考虑用这种
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2018/9/13
 */
public class StaticInnerClassSingleton {
    private static class LazyHold{
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }
    private StaticInnerClassSingleton() {
    }
    public static StaticInnerClassSingleton getInstance(){
        return LazyHold.INSTANCE;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        List list = new ArrayList();
        Set set = new HashSet();
        Queue queue = new LinkedBlockingQueue();
        list.iterator();
        set.iterator();
        map.entrySet().iterator();
        queue.iterator();

    }
}
