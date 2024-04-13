package com.example.jooqtest.configuration;

import com.example.jooqtest.jobs.JobListener;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.autoconfigure.jooq.JooqExceptionTranslator;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Configuration
public class JooqConfiguration {

    int index = 0;

    @Bean
    public DataSource getDataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5433/postgres")
                .username("postgres")
                .password("postgres")
                .build();
    }

    @Bean
    public DataSourceConnectionProvider connectionProvider(DataSource dataSource) {
        return new DataSourceConnectionProvider
                (new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DefaultDSLContext dsl(DefaultConfiguration configuration) {
        return new DefaultDSLContext(configuration);
    }

    @Bean
    public DefaultConfiguration configuration(DataSourceConnectionProvider connectionProvider) {
        DefaultConfiguration jooqConfiguration = new DefaultConfiguration();
        jooqConfiguration.set(connectionProvider);
        jooqConfiguration
                .set(new DefaultExecuteListenerProvider(new JooqExceptionTranslator()));

        return jooqConfiguration;
    }

// ВСЕ ЧТО НИЖЕ РАБОТА ЧЕРЕЗ ItemReader, ItemProcessor, ItemWriter


//    public ItemReader<String> reader() {
//        return () -> {
//            String result = getSourceData(index);
//            index++;
//            return result;
//        };
//    }

//    private String getSourceData(int index){
//        List<String> source = List.of(
//                "Тестовое чтение записи 1",
//                "Тестовое чтение записи 2",
//                "Тестовое чтение записи 3",
//                "Тестовое чтение записи 4",
//                "Тестовое чтение записи 5",
//                "Тестовое чтение записи 6",
//                "Тестовое чтение записи 7"
//                );
//
//        return source.get(index);
//    }


//    public ItemWriter<String> writer() {
//        return (chunk) -> chunk.getItems().forEach(System.out::println);
//    }


//    @Bean("job1")
//    public Job newJob(JobRepository jobRepository, JobExecutionListener listener, Step step1) {
//        return new JobBuilder("importUserJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
//                .listener(listener)
//                .flow(step1)
//                .end()
//                .build();
//    }
//
//    @Bean
//    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("step1", jobRepository)
//                .<String, String> chunk(1, transactionManager)
//                .reader(reader())
//                .processor(processor())
//                .writer(writer())
//                .build();
//    }
//
//    public ItemProcessor<String, String > processor() {
//        return (item -> item + " - Итем процессор");
//    }
//
//    @Bean
//    public JobExecutionListener listener() {
//        return new JobListener();
//    }
}
