package com.bicasteam.movigestion.platform.profilles.domain.model.commands;

public record CreateProfileCommand(String firstName, String lastName, String email, String street, String number, String city) {
}