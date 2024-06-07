package com.bicasteam.movigestion.api.vehicles.domain.repositories;

import com.bicasteam.movigestion.api.vehicles.domain.model.aggregates.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}