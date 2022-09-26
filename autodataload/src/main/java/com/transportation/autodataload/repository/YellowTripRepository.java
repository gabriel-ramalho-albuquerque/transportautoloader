package com.transportation.autodataload.repository;

import com.transportation.autodataload.model.YellowTripDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<YellowTripDTO, Integer> {
}