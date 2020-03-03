package com.example.quartz_springboot.quartz;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 复杂任务的方式
 */
@EnableScheduling
@Component
public class SchedulingConfgerJob implements SchedulingConfigurer {



    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {


        /**
         * 匿名内部类的方式
         */
        taskRegistrar.addTriggerTask(new Runnable() {
            //任务
            @Override
            public void run() {
                System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        }, new Trigger() {
            //触发器
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger("0/1 * * * * ?").nextExecutionTime(triggerContext);
            }
        });




        /**
         * Lambada表达式方式
         */
   /*     taskRegistrar.addTriggerTask(
         ()->{
             System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
         },
         triggerContext ->{
             return new CronTrigger("0/1 * * * * ?").nextExecutionTime(triggerContext);
        });*/




    }




}
