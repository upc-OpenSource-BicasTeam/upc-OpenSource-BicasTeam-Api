package com.bicasteam.movigestion.api.shipments.domain.services;

import com.bicasteam.movigestion.api.shipments.domain.model.aggregates.Shipment;
import com.bicasteam.movigestion.api.shipments.domain.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentCommandService {
    private final ShipmentRepository shipmentRepository;

    @Autowired
    public ShipmentCommandService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public void deleteShipment(Long shipmentId) {
        shipmentRepository.deleteById(shipmentId);
    }
}