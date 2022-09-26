package com.transportation.autodataload.config.batch.writer;

import com.transportation.autodataload.model.GreenTripDTO;
import com.transportation.autodataload.repository.GreenTripRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class GreenTripWriter implements ItemWriter<GreenTripDTO> {

    private final GreenTripRepository tripRepository;

    @Override
    public void write(List<? extends GreenTripDTO> trips)  {
        tripRepository.saveAll(trips);
    }
}