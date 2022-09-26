package com.transportation.autodataload.config.batch.job.step;

import com.transportation.autodataload.config.batch.job.processor.YellowTripProcessor;
import com.transportation.autodataload.model.YellowTripDTO;
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
public class YellowTripStepConfig implements StepConfig {

    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemWriter<YellowTripDTO> tripItemWriter;

    @Autowired
    private  @Qualifier("YellowTripReader") ItemReader<YellowTripDTO> tripItemReader;

    @Bean("YellowTripProcessor")
    public YellowTripProcessor processor() {
        return new YellowTripProcessor();
    }

    @Bean("YellowTripStep")
    @Override
    public Step step() {
        return stepBuilderFactory.get("Yellow Trip step").<YellowTripDTO, YellowTripDTO>chunk(100)
                .reader(tripItemReader)
                .processor(processor())
                .writer(tripItemWriter)
                .build();
    }
}
