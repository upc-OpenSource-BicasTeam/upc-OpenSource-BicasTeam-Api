package com.bicasteam.movigestion.api.vehicles.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUser;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private String modelSerialNumber;

    public Vehicle(Long idUser, String licensePlate, String modelSerialNumber) {
        this.idUser = idUser;
        this.licensePlate = licensePlate;
        this.modelSerialNumber = modelSerialNumber;
    }
}