package com.transportation.autodataload.config.batch.writer;

import com.transportation.autodataload.model.Trip;
import com.transportation.autodataload.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TripWriter implements ItemWriter<Trip> {

    private final TripRepository tripRepository;

    @Override
    public void write(List<? extends Trip> trips)  {
        tripRepository.saveAll(trips);
    }
}