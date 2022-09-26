package com.transportation.autodataload.config.batch.job.processor;

import com.transportation.autodataload.model.YellowTripDTO;
import org.springframework.batch.item.ItemProcessor;

public class YellowTripProcessor implements ItemProcessor<YellowTripDTO, YellowTripDTO> {

    @Override
    public YellowTripDTO process(YellowTripDTO trip) throws Exception {
        trip.setTripTypeId(1);
        return trip;
    }
}
