package com.example.quartz_springboot.quartz;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 简单任务使用的方式
 */
@PropertySource(value = "classpath:application.properties")
@EnableScheduling  //开启任务调度
@Component
public class SimpleJob {

    //自定义方法run();并添加注解@Scheduled,cron表达式
    //@Scheduled(cron = "0/1 * * * * ?") //"cron"触发表达式
    @Scheduled(cron = "${cron.msg}")
    public void run(){
        System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    /**
     * 启动springboot
     * 每秒执行一次
     * log
     * 2020-02-11 18:31:17
     * 2020-02-11 18:31:18
     * 2020-02-11 18:31:19
     * 2020-02-11 18:31:20
     * 2020-02-11 18:31:21
     */


    /**
     * Springboot使用@Scheduled读取配置文件
     *
     * 1,在类上加入注解：
     *
     * @PropertySource(value = "classpath:application.yml")
     *
     *
     *
     * 2,配置文件的配置是这样的
     *
     * \#定时任务执行时间配置
     *
     *
     *
     *    #每个1秒执行一次
     *
     * ```
     * #application.properties
     * cron.msg= 0/1 * * * * ?
     * ```
     *
     *
     *
     * ```
     * #application.yml
     * cron:
     *   msg: 0/1 * * * * ?
     * ```
     *
     *
     *
     * 3,调度任务的方法上 使用
     *
     * @Scheduled(cron="${cron.msg}")    //0/10 * * * * ?
     */





}
