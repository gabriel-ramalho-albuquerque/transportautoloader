package com.transportation.autodataload.config.batch.job;

import com.transportation.autodataload.model.Location;
import com.transportation.autodataload.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
@Primary
@AllArgsConstructor
public class JobConfig {

    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private @Qualifier("LocationStep") Step locationStep;

    @Autowired
    private @Qualifier("YellowTripStep") Step yellowTripStep;

    @Autowired
    private @Qualifier("GreenTripStep") Step greenTripStep;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("CSV autoload job")
                .start(locationStep)
                .next(yellowTripStep)
                .next(greenTripStep)
                .build();
    }
}
