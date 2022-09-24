package com.transportation.autodataload.config.batch.reader.linemapper;

import com.transportation.autodataload.model.Trip;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TripLineMapperConfig implements LineMapperConfig<Trip> {

    @Bean("TripLineMapper")
    @Override
    public LineMapper<Trip> lineMapper() {
        DefaultLineMapper<Trip> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("vendorId", "pickupDateTime", "dropoffDateTime", "passengerCount", "tripDistance", "rateCodeId", "storeAndfwdFlag", "pickupLocation", "dropoffLocation");

        BeanWrapperFieldSetMapper<Trip> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Trip.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }
}
