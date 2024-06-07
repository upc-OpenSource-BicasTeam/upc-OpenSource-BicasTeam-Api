package com.bicasteam.movigestion.api.vehicule.domain.model.queries;

public record GetVehiculeApiKeyAndSourceIdQuery(String newsApikey,
                                                String sourceId) {
    public GetVehiculeApiKeyAndSourceIdQuery {
        if (newsApikey == null) {
            throw new IllegalArgumentException("newsApiKey cannot be null");
        }
        if (sourceId == null) {
            throw new IllegalArgumentException("sourceId cannot be null");
        }
    }
}
