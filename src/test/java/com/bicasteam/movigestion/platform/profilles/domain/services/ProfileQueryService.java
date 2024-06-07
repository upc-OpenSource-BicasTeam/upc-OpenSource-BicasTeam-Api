package com.bicasteam.movigestion.platform.profilles.domain.services;

import com.bicasteam.movigestion.platform.profilles.domain.model.aggregates.Profile;
import com.bicasteam.movigestion.platform.profilles.domain.model.queries.GetProfileByEmailQuery;
import com.bicasteam.movigestion.platform.profilles.domain.model.queries.GetProfileByIdQuery;

import java.util.Optional;

public interface ProfileQueryService {
    Optional<Profile> handle(GetProfileByEmailQuery query);
    Optional<Profile> handle(GetProfileByIdQuery query);
}

