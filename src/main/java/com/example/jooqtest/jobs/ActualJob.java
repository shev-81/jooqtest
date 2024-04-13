package com.example.jooqtest.jobs;

import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.jooqtest.domain.tables.Categories.CATEGORIES;

@Slf4j
@Component
public class ActualJob implements Job {

    @Autowired
    DSLContext dslContext;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        List<String> result = dslContext.select(CATEGORIES.NAME)
                .from(CATEGORIES)
                .fetchInto(String.class);
        log.info(result.toString());
    }
}
