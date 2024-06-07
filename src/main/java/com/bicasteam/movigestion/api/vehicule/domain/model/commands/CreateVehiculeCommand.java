package com.bicasteam.movigestion.api.vehicule.domain.model.commands;

public record CreateVehiculeCommand(String newsApiKey, String sourceId) {
    public CreateVehiculeCommand {
        if (newsApiKey == null || newsApiKey.isBlank()) {
            throw new IllegalArgumentException("newsApiKey cannot be null or empty");
        }
        if (sourceId == null || sourceId.isBlank()) {
            throw new IllegalArgumentException("sourceId cannot be null or empty");
        }
    }
}
