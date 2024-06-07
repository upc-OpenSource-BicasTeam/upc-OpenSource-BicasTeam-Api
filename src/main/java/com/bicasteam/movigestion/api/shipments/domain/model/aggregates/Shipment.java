package com.bicasteam.movigestion.api.shipments.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUserDestiny;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String status;

    public Shipment(Long idUserDestiny, String description, LocalDateTime dateTime, String status) {
        this.idUserDestiny = idUserDestiny;
        this.description = description;
        this.dateTime = dateTime;
        this.status = status;
    }
}