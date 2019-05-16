package com.djcao.sell.zk.zkreadwritelock;

/**
 * @author djcao
 * @workcode wb-cdj390654
 * @date 2019/5/13
 */
public interface IZKLock {

    ZKNode getReadLock() throws InterruptedException;

    ZKNode getWriteLock() throws InterruptedException;

    boolean releaseLock(ZKNode zkNode);

}
