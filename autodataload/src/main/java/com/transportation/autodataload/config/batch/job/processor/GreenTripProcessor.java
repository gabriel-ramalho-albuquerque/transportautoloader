package com.transportation.autodataload.config.batch.job.processor;

import com.transportation.autodataload.model.GreenTripDTO;
import org.springframework.batch.item.ItemProcessor;

public class GreenTripProcessor implements ItemProcessor<GreenTripDTO, GreenTripDTO> {

    @Override
    public GreenTripDTO process(GreenTripDTO trip) throws Exception {
        trip.setTripTypeId(2);
        return trip;
    }
}
