package com.my.demo.job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhile on 2017/4/10.
 */
@Component
public class AutoManager {

    public static SchedulerFactory schedFact = new StdSchedulerFactory();

    @PostConstruct
    public void start() throws Exception {
        //while(true){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Trigger the job to run now, and then every 40 seconds
       /* Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(40)
                        .repeatForever())
                .build();*/

        startTask();

        System.out.println("结束---------------------");

    }


    public static void startTask() throws Exception {
        List<TaskParam> taskParams = new ArrayList<TaskParam>();
        taskParams.add(new TaskParam("1", "task1", "0/1 * * * * ?"));
        taskParams.add(new TaskParam("2", "task2", "0/3 * * * * ?"));
        taskParams.add(new TaskParam("3", "task3", "0/5 * * * * ?"));

        for (TaskParam taskParam : taskParams) {
            Scheduler scheduler = schedFact.getScheduler();
            scheduler.start();
            JobDetail job = JobBuilder.newJob(BaseJob.class)
                    .withIdentity("myJob"+taskParam.getId(), "group1") // name "myJob", group "group1"
                    .storeDurably(true)
                    .build();
            job.getJobDataMap().put("id", taskParam.getId());
            job.getJobDataMap().put("param", taskParam.getParam());
            // Trigger the job to run now, and then every 40 seconds
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(taskParam.getTime());
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("myTrigger"+taskParam.getId(), "group1")
                    .startNow()
                    .withSchedule(cronScheduleBuilder)
                    .build();

            // Tell quartz to schedule the job using our trigger
            try {
                scheduler.scheduleJob(job, trigger);
            } catch (SchedulerException e) {
                e.printStackTrace();
            }
            System.out.println("启动任务---------------------");
        }

    }

    public static void main(String[] args)throws Exception {
        startTask();
    }

}
