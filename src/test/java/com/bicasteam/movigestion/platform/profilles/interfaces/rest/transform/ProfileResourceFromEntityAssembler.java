package com.bicasteam.movigestion.platform.profilles.interfaces.rest.transform;

public class ProfileResourceFromEntityAssembler {
    public static ProfileResource toResourceFromEntity(Profile entity) {
        return new ProfileResource(entity.getId(), entity.getFullName(), entity.getEmailAddress(), entity.getStreetAddress());
    }
}
