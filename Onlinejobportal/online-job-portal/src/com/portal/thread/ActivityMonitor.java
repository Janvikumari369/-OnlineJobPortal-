package com.portal.thread;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicBoolean;

public class ActivityMonitor implements Runnable {
    private final AtomicBoolean running = new AtomicBoolean(true);

    public void stop() { running.set(false); }

    @Override
    public void run() {
        while (running.get()) {
            System.out.println("[Monitor] User activity tick @ " + LocalDateTime.now());
            try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }
    }
}