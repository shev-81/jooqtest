package com.example.jooqtest.jobs;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JobService {

    private final String NAME_JOB = "actualJob";

    private final String CRON_EXPRESSION = "0 * * * * ?";  //каждую минуту


    @Autowired
    private Scheduler scheduler;

    @Autowired
    private ApplicationContext context;



    @PostConstruct
    public void initJobProcess() {
        try {
            log.error("НАЧАЛА ОТРАБАТЫВАТЬ ДЖОБА ПО ШЕДУЛЛЕРУ");
            JobDetail jobDetail = context.getBean(
                    JobDetail.class, NAME_JOB, "ActualJob", ActualJob.class);
            Trigger cronTrigger = context.getBean(
                    Trigger.class, CRON_EXPRESSION, "ActualJob");

            scheduler.scheduleJob(jobDetail, cronTrigger);

        } catch (Exception e) {
            log.warn("Work is error in: {}", e.getMessage());
        }
    }

}
