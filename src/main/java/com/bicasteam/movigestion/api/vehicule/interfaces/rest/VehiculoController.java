package com.bicasteam.movigestion.api.vehicule.interfaces.rest;

import com.acme.catchup.platform.news.domain.model.aggregates.Vehicule;
import com.acme.catchup.platform.news.domain.model.queries.GetAllVehiculeApiKeyQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetVehiculeByIdQuery;
import com.acme.catchup.platform.news.domain.model.queries.GetVehiculeApiKeyAndSourceIdQuery;
import com.acme.catchup.platform.news.domain.services.VehiculeCommandService;
import com.acme.catchup.platform.news.domain.services.VehiculeQueryService;
import com.acme.catchup.platform.news.interfaces.rest.resources.CreateFavoriteSourceResource;
import com.acme.catchup.platform.news.interfaces.rest.resources.FavoriteSourceResource;
import com.acme.catchup.platform.news.interfaces.rest.transform.CreateFavoriteSourceCommandFromResourceAssembler;
import com.acme.catchup.platform.news.interfaces.rest.transform.FavoriteSourceResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/vehicule")
public class VehiculoController {
    private final VehiculeCommandService favoriteSourceCommandService;
    private final VehiculeQueryService favoriteSourceQueryService;

    public VehiculoController(VehiculeCommandService favoriteSourceCommandService, VehiculeQueryService favoriteSourceQueryService) {
        this.favoriteSourceCommandService = favoriteSourceCommandService;
        this.favoriteSourceQueryService = favoriteSourceQueryService;
    }

    @PostMapping
    public ResponseEntity<FavoriteSourceResource>
            createFavoriteSource(@RequestBody CreateFavoriteSourceResource resource) {
        Optional<Vehicule> favoriteSource = favoriteSourceCommandService.
                handle(CreateFavoriteSourceCommandFromResourceAssembler.toCommandFromResource(resource));
        return favoriteSource.map(source -> new ResponseEntity<>(
                FavoriteSourceResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).
                orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("{id}")
    public ResponseEntity<FavoriteSourceResource> getFavoriteSourceById(@PathVariable Long id) {
        Optional<Vehicule> favoriteSource = favoriteSourceQueryService.handle(new GetVehiculeByIdQuery(id));
        return favoriteSource.map(source -> ResponseEntity.ok(FavoriteSourceResourceFromEntityAssembler.
                toResourceFromEntity(source))).
                orElseGet(() -> ResponseEntity.notFound().build());
    }

    private ResponseEntity<List<FavoriteSourceResource>> getAllFavoriteSourcesByNewsApiKey(String newsApiKey){
        var getAllFavoriteSourcesByNewsApiKeyQuery = new GetAllVehiculeApiKeyQuery(newsApiKey);
        var favoriteSources = favoriteSourceQueryService.handle(getAllFavoriteSourcesByNewsApiKeyQuery);
        if (favoriteSources.isEmpty()) return ResponseEntity.notFound().build();
        var favoriteSourcesResources = favoriteSources.stream().map(
                FavoriteSourceResourceFromEntityAssembler:: toResourceFromEntity).toList();
        return ResponseEntity.ok(favoriteSourcesResources);
    }

    private ResponseEntity<FavoriteSourceResource> getFavoriteSourceByNewsApiKeyAndSourceId(
                                                                        String newsApiKey, String sourceId) {
        var getFavoriteSourceByNewsApiKeyAndSourceIdQuery =
                new GetVehiculeApiKeyAndSourceIdQuery(newsApiKey, sourceId);
        var favoriteSource = favoriteSourceQueryService.handle(getFavoriteSourceByNewsApiKeyAndSourceIdQuery);
        if (favoriteSource.isEmpty()) return ResponseEntity.notFound().build();
        return favoriteSource.map(source -> ResponseEntity.ok(
                                            FavoriteSourceResourceFromEntityAssembler.toResourceFromEntity(source)))
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<?> getFavoriteSourcesWithParameters(@RequestParam Map<String, String> params) {
        if (params.containsKey("newsApiKey") && params.containsKey("sourceId")) {
            return getFavoriteSourceByNewsApiKeyAndSourceId(params.get("newsApiKey"), params.get("sourceId"));
        } else if(params.containsKey("newsApiKey")) {
            return getAllFavoriteSourcesByNewsApiKey(params.get("newsApiKey"));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }


}
