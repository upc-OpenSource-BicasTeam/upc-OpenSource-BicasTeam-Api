package com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.application.internal.commandservices;

import com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.domain.model.aggregates.Shipment;
import com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.infrastructure.persistence.jpa.repositories.ShipmentRepository;

public class ShipmentCommandServiceImpl {
    private final ShipmentRepository shipmentRepository;

    public ShipmentCommandServiceImpl(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public Shipment createShipment(Shipment shipment) {
        // Aquí podrías incluir lógica antes de guardar, como validaciones o transformaciones
        return shipmentRepository.save(shipment);
    }

    public Shipment updateShipment(Long id, Shipment shipmentDetails) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Envío no encontrado con id: " + id));
        // Actualizar las propiedades del envío
        shipment.setDestination(shipmentDetails.getDestination());
        shipment.setDescription(shipmentDetails.getDescription());
        shipment.setDateTime(shipmentDetails.getDateTime());
        shipment.setStatus(shipmentDetails.getStatus());
        // Guardar el envío actualizado
        return shipmentRepository.save(shipment);
    }

    public void deleteShipment(Long id) {
        Shipment shipment = shipmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Envío no encontrado con id: " + id));
        shipmentRepository.delete(shipment);
    }

}