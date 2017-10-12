package com.mypro.util;

/**
 * @author yanjiazheng
 * @date 2017/10/12
 */
public class RetryTemplate {
    private int maxRetryTimes = 3;
    private long interval = 200L;

    public RetryTemplate() {
    }

    public RetryTemplate(int maxRetryTimes) {
        if (maxRetryTimes > 0) {
            this.maxRetryTimes = maxRetryTimes;
        }
    }

    public RetryTemplate(int maxRetryTimes, long interval) {
        if (maxRetryTimes > 0) {
            this.maxRetryTimes = maxRetryTimes;
        }
        if (interval > 0) {
            this.interval = interval;
        }
    }

    public <T> T execute(Retryable<T> retryable) {
        int tryCnt = 0;
        T result = null;
        for (int i = 0; i < maxRetryTimes; i++) {
            result = retryable.retry();
            if (result != null) {
                return result;
            }
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {

            }
        }
        return result;
    }

    public interface Retryable<T> {
        T retry();
    }
}
