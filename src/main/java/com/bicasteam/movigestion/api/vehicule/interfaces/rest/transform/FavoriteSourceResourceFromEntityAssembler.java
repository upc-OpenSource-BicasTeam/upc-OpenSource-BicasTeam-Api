package com.bicasteam.movigestion.api.vehicule.interfaces.rest.transform;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import com.acme.catchup.platform.news.interfaces.rest.resources.FavoriteSourceResource;

public class FavoriteSourceResourceFromEntityAssembler {
    public static FavoriteSourceResource toResourceFromEntity(Vehicule entity) {
        return new FavoriteSourceResource(entity.getId(), entity.getNewsApikey(), entity.getSourceId());
    }
}
