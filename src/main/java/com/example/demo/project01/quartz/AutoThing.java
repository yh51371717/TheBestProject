package com.example.demo.project01.quartz;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class AutoThing {
    @Async
    @Scheduled(cron = "0 0/5 9 * * ? ")   //秒 分 时 日 月 周 年（年可省） /左边是时间 /右边是间隔
    public void run(){
        System.out.println("我是定时任务开始执行");
        System.out.println("我是定时任务执行完毕");
    }
}
