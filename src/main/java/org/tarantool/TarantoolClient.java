package org.tarantool;

import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface TarantoolClient {
    TarantoolClientOps<Integer, Object, Object, List> syncOps();

    TarantoolClientOps<Integer, Object, Object, Future<List>> asyncOps();

    TarantoolClientOps<Integer, Object, Object, Long> fireAndForgetOps();

    void close();

    boolean isAlive();

    void waitAlive() throws InterruptedException;

    void waitAlive(long timeout, TimeUnit unit) throws InterruptedException;

}
