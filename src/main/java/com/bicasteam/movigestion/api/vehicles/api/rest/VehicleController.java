package com.bicasteam.movigestion.api.vehicles.api.rest;

import com.bicasteam.movigestion.api.vehicles.application.commands.CreateVehicleCommand;
import com.bicasteam.movigestion.api.vehicles.domain.model.aggregates.Vehicle;
import com.bicasteam.movigestion.api.vehicles.domain.services.VehicleCommandService;
import com.bicasteam.movigestion.api.vehicles.domain.services.VehicleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleCommandService vehicleCommandService;
    private final VehicleQueryService vehicleQueryService;

    @Autowired
    public VehicleController(VehicleCommandService vehicleCommandService, VehicleQueryService vehicleQueryService) {
        this.vehicleCommandService = vehicleCommandService;
        this.vehicleQueryService = vehicleQueryService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleQueryService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleQueryService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vehicle createVehicle(@RequestBody CreateVehicleCommand command) {
        Vehicle vehicle = new Vehicle(command.idUser(), command.licensePlate(), command.modelSerialNumber());
        return vehicleCommandService.createVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVehicle(@PathVariable Long id) {
        vehicleCommandService.deleteVehicle(id);
    }
}
