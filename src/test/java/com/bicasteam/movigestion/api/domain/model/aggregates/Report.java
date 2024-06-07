package com.bicasteam.movigestion.api.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long idUser;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    public Report(Long idUser, String type, String description, LocalDateTime dateTime) {
        this.idUser = idUser;
        this.type = type;
        this.description = description;
        this.dateTime = dateTime;
    }
}
