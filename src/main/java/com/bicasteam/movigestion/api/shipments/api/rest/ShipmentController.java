package com.bicasteam.movigestion.api.shipments.api.rest;

import com.bicasteam.movigestion.api.shipments.application.commands.CreateShipmentCommand;
import com.bicasteam.movigestion.api.shipments.application.commands.DateTimeContainer;
import com.bicasteam.movigestion.api.shipments.domain.model.aggregates.Shipment;
import com.bicasteam.movigestion.api.shipments.domain.services.ShipmentCommandService;
import com.bicasteam.movigestion.api.shipments.domain.services.ShipmentQueryService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public ResponseEntity<ShipmentDto> createShipment(@RequestBody CreateShipmentCommand command) {
        LocalDateTime dateTime = LocalDateTime.of(
                LocalDate.parse(command.dateTime().date()),
                LocalTime.parse(command.dateTime().time())
        );
        Shipment shipment = new Shipment(
                Long.parseLong(command.idUser()),
                command.destiny(),
                command.description(),
                dateTime,
                command.status()
        );
        Shipment savedShipment = shipmentCommandService.createShipment(shipment);
        ShipmentDto shipmentDto = mapToShipmentDto(savedShipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(shipmentDto);
    }
    private ShipmentDto mapToShipmentDto(Shipment shipment) {
        return new ShipmentDto(
                shipment.getId(),
                shipment.getIdUserDestiny(),
                shipment.getDestiny(),
                shipment.getDescription(),
                new DateTimeContainer(
                        shipment.getDateTime().toLocalDate().toString(),
                        shipment.getDateTime().toLocalTime().toString()
                ),
                shipment.getStatus()
        );
    }



    @Data
    @AllArgsConstructor
    public static class ShipmentDto {
        private Long id;
        private Long idUser;
        private String destiny;
        private String description;
        private DateTimeContainer dateTime;
        private String status;
    }






    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteShipment(@PathVariable Long id) {
        if (shipmentQueryService.getShipmentById(id).isPresent()) {
            shipmentCommandService.deleteShipment(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
