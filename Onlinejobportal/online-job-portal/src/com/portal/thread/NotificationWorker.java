package com.portal.thread;

import com.portal.common.AppConfig;
import com.portal.model.Application;

import java.util.concurrent.BlockingQueue;

public class NotificationWorker implements Runnable {
    private final BlockingQueue<Application> queue;

    public NotificationWorker(BlockingQueue<Application> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Application app = queue.take();
                System.out.println("[Notify] New application received: " + app);
                Thread.sleep(AppConfig.NOTIFY_WORKER_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}