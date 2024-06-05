package com.bicasteam.movigestion.api.movigestion.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class VehiculeSource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private String id;

}
