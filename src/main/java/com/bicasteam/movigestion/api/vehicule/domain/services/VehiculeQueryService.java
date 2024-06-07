package com.bicasteam.movigestion.api.vehicule.domain.services;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import com.acme.catchup.platform.news.domain.model.queries.GetAllVehiculeApiKeyQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetVehiculeByIdQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetVehiculeApiKeyAndSourceIdQuery;

import java.util.List;
import java.util.Optional;

public interface VehiculeQueryService {
    List<Vehicule> handle(GetAllVehiculeApiKeyQuery query);
    Optional<Vehicule> handle(GetVehiculeByIdQuery query);
    Optional<Vehicule> handle(GetVehiculeApiKeyAndSourceIdQuery query);

}
