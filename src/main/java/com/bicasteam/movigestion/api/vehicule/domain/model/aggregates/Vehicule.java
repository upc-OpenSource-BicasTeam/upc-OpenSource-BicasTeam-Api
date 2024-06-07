package com.bicasteam.movigestion.api.vehicule.domain.model.aggregates;

import com.acme.catchup.platform.news.domain.model.commands.CreateVehiculeCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String numberPlate;

    @Column(nullable = false)
    @Getter
    private String numberSerial;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updatedAt;

    protected Vehicule(){}

    /**
     * Constructor
     * It creates a new FavoriteSource instance
     * @param command -  the CreateFavoriteSourceCommand command
     */
    public Vehicule(CreateVehiculeCommand command){
        this.newsApikey = command.newsApiKey();
        this.sourceId = command.sourceId();
    }

}
