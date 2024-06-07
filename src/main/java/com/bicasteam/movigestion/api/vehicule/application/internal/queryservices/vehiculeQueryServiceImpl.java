package com.bicasteam.movigestion.api.vehicule.application.internal.queryservices;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import com.acme.catchup.platform.news.domain.model.queries.GetAllVehiculeApiKeyQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetVehiculeByIdQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetVehiculeApiKeyAndSourceIdQuery;
import com.acme.catchup.platform.news.domain.services.VehiculeQueryService;
import com.acme.catchup.platform.news.infraestructure.persistance.jpa.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class vehiculeQueryServiceImpl implements VehiculeQueryService {
    private final VehiculeRepository favoriteSourceRepository;

    public vehiculeQueryServiceImpl(VehiculeRepository favoriteSourceRepository) {
        this.favoriteSourceRepository = favoriteSourceRepository;
    }

    /**
     * Handles the GetAllFavoriteSourceByNewsApiKeyQuery query
     * @param query - the GetAllFavoriteSourceByNewsApiKeyQuery query
     * @return a list of FavoriteSource
     */
    @Override
    public List<Vehicule> handle(GetAllVehiculeApiKeyQuery query) {
        return favoriteSourceRepository.findAllByNewsApikey(query.newsApiKey());
    }

    /**
     * Handles the GetFavoriteSourceByIdQuery query
     * @param query - the GetFavoriteSourceByIdQuery query
     * @return an Optional of FavoriteSource
     */
    @Override
    public Optional<Vehicule> handle(GetVehiculeByIdQuery query) {
        return favoriteSourceRepository.findById(query.id());
    }

    /**
     * Handles the GetFavoriteSourceByNewsApiKeyAndSourceId query.
     * @param query - the GetFavoriteSourceByNewsApiKeyAndSourceId query
     * @return an Optional of FavoriteSource
     */
    @Override
    public Optional<Vehicule> handle(GetVehiculeApiKeyAndSourceIdQuery query) {
        return favoriteSourceRepository.findByNewsApikeyAndSourceId(query.newsApikey(), query.sourceId());
    }

}
