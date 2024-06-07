package com.bicasteam.movigestion.api.vehicule.application.internal.commandservices;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import com.acme.catchup.platform.news.domain.model.commands.CreateVehiculeCommand;
import com.acme.catchup.platform.news.domain.services.VehiculeCommandService;
import com.acme.catchup.platform.news.infraestructure.persistance.jpa.VehiculeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class vehiculeCommandServiceImpl implements VehiculeCommandService {
    private final VehiculeRepository favoriteSourceRepository;

    public vehiculeCommandServiceImpl(VehiculeRepository favoriteSourceRepository) {
        this.favoriteSourceRepository = favoriteSourceRepository;
    }

    /**
     * Handles the CreateFavoriteSourceCommand command.
     * @param command - the CreateFavoriteSourceCommand command
     * @return an Optional of FavoriteSource
     */
    @Override
    public Optional<Vehicule> handle(CreateVehiculeCommand command) {
        if (favoriteSourceRepository.existsByNewsApikeyAndSourceId(command.newsApiKey(),
                                                                    command.sourceId())) {
            throw new IllegalArgumentException("Favorite Source with same source Id already for this Api Key");
        }
        var favoriteSource = new Vehicule(command);
        var createdFavoriteSource = favoriteSourceRepository.save(favoriteSource);
        return Optional.of(createdFavoriteSource);
    }
}
