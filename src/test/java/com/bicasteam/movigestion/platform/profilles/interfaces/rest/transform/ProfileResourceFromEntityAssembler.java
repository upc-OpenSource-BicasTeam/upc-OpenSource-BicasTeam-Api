package com.bicasteam.movigestion.platform.profilles.interfaces.rest.transform;

import com.bicasteam.movigestion.platform.profilles.domain.model.aggregates.Profile;
import com.bicasteam.movigestion.platform.profilles.interfaces.rest.resources.ProfileResource;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmailAddress(), entity.getStreetAddress());
    }
}
