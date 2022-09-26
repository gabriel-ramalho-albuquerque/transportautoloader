package com.transportation.autodataload.config.batch.writer;

import com.transportation.autodataload.model.Location;
import com.transportation.autodataload.repository.LocationRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LocationWriter implements ItemWriter<Location> {

    private final LocationRepository locationRepository;

    @Override
    public void write(List<? extends Location> locations)  {
        locationRepository.saveAll(locations);
    }
}