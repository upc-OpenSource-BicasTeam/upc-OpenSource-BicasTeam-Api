package com.bicasteam.movigestion.api.iam.interfaces.rest.resources;

public record UserResource(Long id,
                           String name,
                           String lastName,
                           String email,
                           String type) {
}
