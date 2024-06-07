package com.bicasteam.movigestion.api.vehicule.interfaces.rest.transform;

import com.acme.catchup.platform.news.domain.model.commands.CreateVehiculeCommand;
import com.acme.catchup.platform.news.interfaces.rest.resources.CreateFavoriteSourceResource;

public class CreateFavoriteSourceCommandFromResourceAssembler {
    public static CreateVehiculeCommand toCommandFromResource(CreateFavoriteSourceResource resource) {
        return new CreateVehiculeCommand(resource.newsApiKey(), resource.sourceId());
    }
}
