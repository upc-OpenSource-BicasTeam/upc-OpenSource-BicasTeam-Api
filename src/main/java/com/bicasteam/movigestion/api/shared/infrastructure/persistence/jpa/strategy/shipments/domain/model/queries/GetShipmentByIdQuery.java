package com.bicasteam.movigestion.api.shared.infrastructure.persistence.jpa.strategy.shipments.domain.model.queries;

public class GetShipmentByIdQuery {
    private Long id;

    // Constructor
    public GetShipmentByIdQuery(Long id) {
        this.id = id;
    }

    // Getter
    public Long getId() {
        return id;
    }
}