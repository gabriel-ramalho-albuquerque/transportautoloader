package com.transportation.autodataload.config.batch.reader;

import com.transportation.autodataload.model.Location;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@AllArgsConstructor
public class LocationReaderConfig implements ReaderConfig<Location> {
    private final LineMapper<Location> locationLineMapper;

    @Bean("LocationReader")
    @Override
    public FlatFileItemReader<Location> reader() {
        FlatFileItemReader<Location> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/csv/zone/zones.csv"));
        itemReader.setName("Location reader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(locationLineMapper);

        return itemReader;
    }
}
