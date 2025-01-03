package com.roger.test.util;

import android.os.Handler;

import java.util.concurrent.TimeUnit;

/**
 * 定时任务
 */
public class PeriodicTaskUtil {
    private Handler handler;
    private Runnable runnable;
    private long intervalMillis;
    private TaskCallback callback;

    public PeriodicTaskUtil(long interval, TimeUnit timeUnit, TaskCallback callback) {
        this.intervalMillis = timeUnit.toMillis(interval);
        this.callback = callback;
        handler = new Handler();
    }

    public void startPeriodicTask() {
        if (runnable == null) {
            runnable = new Runnable() {
                @Override
                public void run() {
                    if (callback != null) {
                        callback.onTask();
                    }
                    handler.postDelayed(this, intervalMillis);
                }
            };
        }
        handler.post(runnable);
    }

    public void stopPeriodicTask() {
        if (runnable != null) {
            handler.removeCallbacks(runnable);
            runnable = null;
        }
    }

    public interface TaskCallback {
        void onTask();
    }
}
