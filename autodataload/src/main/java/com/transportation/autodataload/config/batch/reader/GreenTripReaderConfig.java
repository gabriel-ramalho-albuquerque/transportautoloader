package com.transportation.autodataload.config.batch.reader;

import com.transportation.autodataload.model.GreenTripDTO;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@AllArgsConstructor
public class GreenTripReaderConfig implements ReaderConfig<GreenTripDTO> {

    private final LineMapper<GreenTripDTO> greenTripLineMapper;

    @Bean("GreenTripReader")
    @Override
    public FlatFileItemReader<GreenTripDTO> reader() {
        FlatFileItemReader<GreenTripDTO> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/csv/greenTrip/green_tripdata_2018-01_01-15.csv"));
        itemReader.setName("Green Trip reader");
        itemReader.setLineMapper(greenTripLineMapper);

        return itemReader;
    }
}