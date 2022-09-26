package com.transportation.autodataload.repository;

import com.transportation.autodataload.model.GreenTripDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GreenTripRepository extends JpaRepository<GreenTripDTO, Integer> {
}
