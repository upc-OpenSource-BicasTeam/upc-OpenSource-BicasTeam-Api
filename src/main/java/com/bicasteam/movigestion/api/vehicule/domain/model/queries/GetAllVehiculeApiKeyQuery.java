package com.bicasteam.movigestion.api.vehicule.domain.model.queries;

public record GetAllVehiculeApiKeyQuery(String newsApiKey) {
    public GetAllVehiculeApiKeyQuery {
        if (newsApiKey == null || newsApiKey.isBlank()) {
            throw new IllegalArgumentException("Api Key cannot be null or empty");
        }
    }
}
