package com.bicasteam.movigestion.api.vehicles.domain.services;

import com.bicasteam.movigestion.api.vehicles.domain.model.aggregates.Vehicle;
import com.bicasteam.movigestion.api.vehicles.domain.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleCommandService {
    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleCommandService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public void deleteVehicle(Long vehicleId) {
        vehicleRepository.deleteById(vehicleId);
    }
}