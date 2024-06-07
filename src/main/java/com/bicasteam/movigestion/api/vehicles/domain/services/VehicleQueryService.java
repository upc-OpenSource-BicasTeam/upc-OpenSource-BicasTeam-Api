package com.bicasteam.movigestion.api.vehicles.domain.services;

import com.bicasteam.movigestion.api.vehicles.domain.model.aggregates.Vehicle;
import com.bicasteam.movigestion.api.vehicles.domain.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleQueryService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleQueryService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Optional<Vehicle> getVehicleById(Long vehicleId) {
        return vehicleRepository.findById(vehicleId);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
