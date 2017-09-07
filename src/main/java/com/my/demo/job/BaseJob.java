package com.my.demo.job;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzhile on 2017/4/10.
 */
@Service("baseJob")
public class BaseJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        String param = mergedJobDataMap.getString("param");
        String id = mergedJobDataMap.getString("id");
        System.out.println("执行"+id+",param="+param);
    }
}
