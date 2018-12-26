/*
 *
 *  * Copyright (C), 2002-2014, 苏宁易购电子商务有限公司
 *  * FileName: ShopExecutorService.java
 *  * Author:   18051080
 *  * Date:     2018年8月15日PM03:12:34
 *  * Description: //模块目的、功能描述
 *  * History: //修改记录
 *  * <author>      <time>      <version>    <desc>
 *  * 修改人姓名             修改时间            版本号                  描述
 *
 */

package com.xaven.shop.util;

import java.util.concurrent.*;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;

public class ShopExecutorService {

    private volatile static ShopExecutorService   instance          = null;

    // 设置默认初始线程池的大小
    private static final int                      corePoolSize      = 24;

    private static final int                      maximumPoolSize   = 50;

    private static final int                      queueSize         = 500;

    private static final long                     keepLiveTime      = 5L;

    private static final BlockingQueue<Runnable>  queue             = new ArrayBlockingQueue<Runnable>(
            queueSize);

    private static final RejectedExecutionHandler callerRunsHandler = new CallerRunsPolicy();

    private ExecutorService                       boundedThreadPool;




    public static ShopExecutorService getInstance() {
        if (instance == null) {
            synchronized (ShopExecutorService.class) {
                if (instance == null) {
                    instance = new ShopExecutorService();
                }
            }
        }
        return instance;
    }

    private ShopExecutorService() {
        boundedThreadPool = new ThreadPoolExecutor(corePoolSize,
                maximumPoolSize, keepLiveTime, TimeUnit.SECONDS, queue,
                callerRunsHandler);
    }

    public ExecutorService getBoundedThreadPool() {
        return boundedThreadPool;
    }

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService = ShopExecutorService.getInstance().boundedThreadPool;

        CountDownLatch countDownLatch = new CountDownLatch(100);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            ShopExecutorService.doSomeThing();
        }
        System.out.println("单线程耗时：" + (System.currentTimeMillis() - startTime));

        long startTime2 = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            ShopExecutorService.getInstance().boundedThreadPool
                    .execute(new Runnable() {

                        @Override
                        public void run() {
                            ShopExecutorService.doSomeThing();
                            countDownLatch.countDown();
                        }

                    });
        }
        ShopExecutorService.getInstance().boundedThreadPool.shutdown();
        /*for (;;) {
            if (ShopExecutorService.getInstance().boundedThreadPool
                    .isTerminated()) {
                break;
            }
        }*/
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out
                .println("线程池耗时：" + (System.currentTimeMillis() - startTime2));

    }

    /**
     * 模拟操作
     */
    private static void doSomeThing() {
        try {
            Thread.sleep(1000l);
            System.out.println(
                    "do something..." + Thread.currentThread().getName() +"队列大小："+ queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
