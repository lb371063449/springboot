package com.rinbo.springboot.controller;

import com.rinbo.springboot.concurrency.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.concurrent.Callable;

/**
 *
 *
 * 1. 开启@Async注解

        在Spring Boot主类添加@EnableAsync注解

   2. 定义异步任务

        定义Task类，创建三个处理函数分别模拟三个执行任务的操作，操作消耗时间随机取（10秒内）。
 *
 *
 *
 *
 */
@Controller
@RequestMapping("/async")
public class AsyncController {

    @Autowired
    private Task task;

    @ResponseBody
    @RequestMapping("/task")
    public String task() throws Exception {
        System.out.println("开始执行Controller任务");
        long start = System.currentTimeMillis();
        task.doTaskOne();
        task.doTaskTwo();
        task.doTaaskThree();
        long end = System.currentTimeMillis();
        System.out.println("完成Controller任务，耗时：" + (end - start) + "毫秒");
        return "success";
    }

    @RequestMapping("/atask")
    @ResponseBody
    public WebAsyncTask<String> webAsyncTask() {
        System.out.println("webAsyncTask 主线程。。。。。。。。。。。。");
        WebAsyncTask<String> webAsyncTask = new WebAsyncTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                System.out.println("webAsyncTask 正在执行。。。");
                return "久等了";
            }
        });
        System.out.println("退出webAsyncTask主线程。。。。。。。。。。。。");
        return webAsyncTask;
    }

    @RequestMapping("/dtask")
    @ResponseBody
    public DeferredResult<String> deferredTask() {
      final DeferredResult<String> result = new DeferredResult<>(7*1000L,"超时了");
      approve(result);
      return result;
    }

    private void approve(DeferredResult<String> result) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5* 1000L);
                    result.setResult("i am agree");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        new Thread(r).start();
    }

}
