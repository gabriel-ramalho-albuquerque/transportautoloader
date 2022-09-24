package com.transportation.autodataload.config;

import com.transportation.autodataload.entity.Location;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
@Primary
@AllArgsConstructor
public class BatchConfig {

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    private LocationRepository locationRepository;

    @Bean
    public FlatFileItemReader<Location> reader(String path) {
        FlatFileItemReader<Location> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource(path));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());

        return itemReader;
    }

    private LineMapper<Location> lineMapper() {
        DefaultLineMapper<Location> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "borough", "zone", "service_zone");

        BeanWrapperFieldSetMapper<Location> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Location.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

    @Bean
    public RepositoryItemWriter<Location> writer() {
        RepositoryItemWriter<Location> writer = new RepositoryItemWriter<>();
        writer.setRepository(locationRepository);
        writer.setMethodName("save");

        return writer;
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("csv-step1").<Location, Location>chunk(30)
                .reader(reader("src/main/resources/zones.csv"))
                .writer(writer())
                .build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("importLocationsJob")
                .flow(step1())
                .end()
                .build();
    }
}
