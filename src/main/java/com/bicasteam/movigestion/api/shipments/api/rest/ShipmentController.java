package com.bicasteam.movigestion.api.shipments.api.rest;

import com.bicasteam.movigestion.api.shipments.application.commands.CreateShipmentCommand;
import com.bicasteam.movigestion.api.shipments.domain.model.aggregates.Shipment;
import com.bicasteam.movigestion.api.shipments.domain.services.ShipmentCommandService;
import com.bicasteam.movigestion.api.shipments.domain.services.ShipmentQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipments")
public class ShipmentController {
    private final ShipmentCommandService shipmentCommandService;
    private final ShipmentQueryService shipmentQueryService;

    @Autowired
    public ShipmentController(ShipmentCommandService shipmentCommandService, ShipmentQueryService shipmentQueryService) {
        this.shipmentCommandService = shipmentCommandService;
        this.shipmentQueryService = shipmentQueryService;
    }

    @GetMapping
    public List<Shipment> getAllShipments() {
        return shipmentQueryService.getAllShipments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shipment> getShipmentById(@PathVariable Long id) {
        return shipmentQueryService.getShipmentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment createShipment(@RequestBody CreateShipmentCommand command) {
        Shipment shipment = new Shipment(command.idUserDestiny(), command.description(), command.dateTime(), command.status());
        return shipmentCommandService.createShipment(shipment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteShipment(@PathVariable Long id) {
        shipmentCommandService.deleteShipment(id);
    }
}