package com.transportation.autodataload.config.batch.writer;

import com.transportation.autodataload.model.YellowTripDTO;
import com.transportation.autodataload.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TripWriter implements ItemWriter<YellowTripDTO> {

    private final TripRepository tripRepository;

    @Override
    public void write(List<? extends YellowTripDTO> trips)  {
        tripRepository.saveAll(trips);
    }
}