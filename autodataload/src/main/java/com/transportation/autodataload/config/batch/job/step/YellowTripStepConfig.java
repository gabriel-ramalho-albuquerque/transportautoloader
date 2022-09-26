package com.transportation.autodataload.config.batch.job.step;

import com.transportation.autodataload.config.batch.job.processor.YellowTripProcessor;
import com.transportation.autodataload.model.Trip;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class TripStepConfig implements StepConfig {

    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemWriter<Trip> tripItemWriter;

    @Autowired
    private  @Qualifier("TripReader") ItemReader<Trip> tripItemReader;

    @Bean
    public YellowTripProcessor processor() {
        return new YellowTripProcessor();
    }

    @Bean("TripStep")
    @Override
    public Step step() {
        return stepBuilderFactory.get("Trip step").<Trip, Trip>chunk(100)
                .reader(tripItemReader)
                .processor(processor())
                .writer(tripItemWriter)
                .build();
    }
}
