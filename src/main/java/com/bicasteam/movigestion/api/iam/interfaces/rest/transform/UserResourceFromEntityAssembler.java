package com.bicasteam.movigestion.api.iam.interfaces.rest.transform;

import com.bicasteam.movigestion.api.iam.domain.model.entities.User;
import com.bicasteam.movigestion.api.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User entity) {
        return new UserResource(entity.getId(), entity.getName(), entity.getLastName(),
                entity.getEmail(), entity.getType());
    }
}