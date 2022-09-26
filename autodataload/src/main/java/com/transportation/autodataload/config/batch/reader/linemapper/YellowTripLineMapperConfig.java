package com.transportation.autodataload.config.batch.reader.linemapper;

import com.transportation.autodataload.model.YellowTripDTO;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class YellowTripLineMapperConfig implements LineMapperConfig<YellowTripDTO> {

    @Bean("YellowTripLineMapper")
    @Override
    public LineMapper<YellowTripDTO> lineMapper() {
        DefaultLineMapper<YellowTripDTO> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("vendorId", "pickupDateTime", "dropoffDateTime", "passengerCount", "tripDistance", "rateCodeId", "storeAndfwdFlag", "pickupLocation", "dropoffLocation");

        BeanWrapperFieldSetMapperCustom<YellowTripDTO> fieldSetMapper = new BeanWrapperFieldSetMapperCustom<>();
        fieldSetMapper.setTargetType(YellowTripDTO.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }
}
