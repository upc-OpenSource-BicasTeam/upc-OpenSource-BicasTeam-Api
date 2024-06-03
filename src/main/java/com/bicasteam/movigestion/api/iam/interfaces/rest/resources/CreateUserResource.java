package com.bicasteam.movigestion.api.iam.interfaces.rest.resources;

public record CreateUserResource(String name,
                                 String lastName,
                                 String email,
                                 String password,
                                 String type) {
}