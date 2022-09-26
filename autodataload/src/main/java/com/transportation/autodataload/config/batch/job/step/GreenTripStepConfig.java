package com.transportation.autodataload.config.batch.job.step;

import com.transportation.autodataload.config.batch.job.processor.GreenTripProcessor;
import com.transportation.autodataload.model.GreenTripDTO;
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
public class GreenTripStepConfig {

    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemWriter<GreenTripDTO> tripItemWriter;

    @Autowired
    private  @Qualifier("GreenTripReader") ItemReader<GreenTripDTO> tripItemReader;

    @Bean("GreenTripProcessor")
    public GreenTripProcessor processor() {
        return new GreenTripProcessor();
    }

    @Bean("GreenTripStep")
    public Step step() {
        return stepBuilderFactory.get("Green Trip step").<GreenTripDTO, GreenTripDTO>chunk(100)
                .reader(tripItemReader)
                .processor(processor())
                .writer(tripItemWriter)
                .build();
    }
}
