package com.bicasteam.movigestion.platform.profilles.application.internal.queryservices;

import com.bicasteam.movigestion.platform.profilles.domain.model.aggregates.Profile;
import com.bicasteam.movigestion.platform.profilles.domain.model.queries.GetProfileByEmailQuery;
import com.bicasteam.movigestion.platform.profilles.domain.model.queries.GetProfileByIdQuery;
import com.bicasteam.movigestion.platform.profilles.domain.services.ProfileQueryService;
import com.bicasteam.movigestion.platform.profilles.infraestructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final ProfileRepository profileRepository;

    public ProfileQueryServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Optional<Profile> handle(GetProfileByEmailQuery query) {
        return profileRepository.findByEmail(query.emailAddress());
    }

    @Override
    public Optional<Profile> handle(GetProfileByIdQuery query) {
        return profileRepository.findById(query.profileId());
    }
}