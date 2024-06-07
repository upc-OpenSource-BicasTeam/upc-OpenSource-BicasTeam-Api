package com.bicasteam.movigestion.api.vehicule.domain.services;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import com.acme.catchup.platform.news.domain.model.commands.CreateVehiculeCommand;

import java.util.Optional;

public interface VehiculeCommandService {
    Optional<Vehicule> handle(CreateVehiculeCommand command);
}
