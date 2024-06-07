package com.bicasteam.movigestion.api.shipments.domain.services;

import com.bicasteam.movigestion.api.shipments.domain.model.aggregates.Shipment;
import com.bicasteam.movigestion.api.shipments.domain.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentQueryService {
    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentQueryService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Optional<Shipment> getShipmentById(Long shipmentId) {
        return shipmentRepository.findById(shipmentId);
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }
}