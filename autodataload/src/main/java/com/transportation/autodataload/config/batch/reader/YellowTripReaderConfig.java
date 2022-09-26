package com.transportation.autodataload.config.batch.reader;

import com.transportation.autodataload.model.YellowTripDTO;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
@AllArgsConstructor
public class YellowTripReaderConfig implements ReaderConfig<YellowTripDTO> {

    private final LineMapper<YellowTripDTO> tripLineMapper;

    @Bean("YellowTripReader")
    @Override
    public FlatFileItemReader<YellowTripDTO> reader() {
        FlatFileItemReader<YellowTripDTO> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/csv/yellowTrip/yellow_tripdata_2018-01_01-15.csv"));
        itemReader.setName("Yellow Trip reader");
        itemReader.setLineMapper(tripLineMapper);

        return itemReader;
    }
}
