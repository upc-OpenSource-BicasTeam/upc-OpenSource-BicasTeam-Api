package com.bicasteam.movigestion.api.iam.domain.model.commands;

public record CreateUserCommand(String name, String lastName, String email,
                                String password, String type) {
}