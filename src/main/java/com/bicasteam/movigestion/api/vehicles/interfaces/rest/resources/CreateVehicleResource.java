package com.bicasteam.movigestion.api.vehicles.interfaces.rest.resources;

import java.time.LocalDateTime;

public record CreateVehicleResource(
        String licensePlate,
        String model,
        int engine,
        int fuel,
        int tires,
        int electricalSystem,
        int transmissionTemperature,
        String driverName,
        String vehicleImage,
        String color,
        LocalDateTime lastTechnicalInspectionDate
) {}
