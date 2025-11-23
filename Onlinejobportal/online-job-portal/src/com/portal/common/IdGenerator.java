package com.portal.common;

import java.util.concurrent.atomic.AtomicInteger;

public final class IdGenerator {
    private static final AtomicInteger USER_SEQ = new AtomicInteger(1000);
    private static final AtomicInteger JOB_SEQ = new AtomicInteger(2000);
    private static final AtomicInteger APP_SEQ = new AtomicInteger(3000);
    private static final AtomicInteger MSG_SEQ = new AtomicInteger(4000);

    private IdGenerator() {}

    public static int nextUserId() { return USER_SEQ.incrementAndGet(); }
    public static int nextJobId() { return JOB_SEQ.incrementAndGet(); }
    public static int nextApplicationId() { return APP_SEQ.incrementAndGet(); }
    public static int nextMessageId() { return MSG_SEQ.incrementAndGet(); }
}