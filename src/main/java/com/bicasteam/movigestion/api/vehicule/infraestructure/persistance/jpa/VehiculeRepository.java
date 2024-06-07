package com.bicasteam.movigestion.api.vehicule.infraestructure.persistance.jpa;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    List<Vehicule> findAllByNewsApikey(String newsApiKey);
    boolean existsByNewsApikeyAndSourceId(String newsApiKey, String sourceId);

    Optional<Vehicule> findByNewsApikeyAndSourceId(String newsApiKey, String sourceId);

}
