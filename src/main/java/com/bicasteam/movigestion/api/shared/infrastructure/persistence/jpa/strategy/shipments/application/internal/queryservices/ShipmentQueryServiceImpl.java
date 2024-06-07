package com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.application.internal.queryservices;

import com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.domain.model.aggregates.Shipment;
import com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.infrastructure.persistence.jpa.repositories.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentQueryServiceImpl {
    private final ShipmentRepository shipmentRepository;

    public ShipmentQueryServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(Long id) {
        return shipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Envío no encontrado con id: " + id));
    }


}
