package com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.infrastructure.persistence.jpa.repositories;

import com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.domain.model.aggregates.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    // Métodos para interactuar con la base de datos
}
