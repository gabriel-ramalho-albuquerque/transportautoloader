package com.transportation.autodataload.repository;

import com.transportation.autodataload.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}