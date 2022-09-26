package com.transportation.autodataload.config.batch.job.step;

import com.transportation.autodataload.model.Location;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@AllArgsConstructor
public class LocationStepConfig implements StepConfig{
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemWriter<Location> locationItemWriter;

    @Autowired
    private  @Qualifier("LocationReader") ItemReader<Location> locationItemReader;

    @Bean("LocationStep")
    @Primary
    @Override
    public Step step() {
        return stepBuilderFactory.get("Location step").<Location, Location>chunk(30)
                .reader(locationItemReader)
                .writer(locationItemWriter)
                .build();
    }
}
