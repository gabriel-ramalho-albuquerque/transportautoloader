package com.transportation.autodataload.repository;

import com.transportation.autodataload.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Integer> {
}