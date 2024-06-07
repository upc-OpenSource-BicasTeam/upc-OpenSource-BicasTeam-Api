package com.bicasteam.movigestion.platform.profilles.interfaces.rest;

import com.bicasteam.movigestion.platform.profilles.domain.model.commands.CreateProfileCommand;
import com.bicasteam.movigestion.platform.profilles.domain.model.queries.GetProfileByIdQuery;
import com.bicasteam.movigestion.platform.profilles.domain.services.ProfileCommandService;
import com.bicasteam.movigestion.platform.profilles.domain.services.ProfileQueryService;
import com.bicasteam.movigestion.platform.profilles.interfaces.rest.resources.CreateProfileResource;
import com.bicasteam.movigestion.platform.profilles.interfaces.rest.resources.ProfileResource;
import com.bicasteam.movigestion.platform.profilles.interfaces.rest.transform.CreateProfileCommandFromResourceAssembler;
import com.bicasteam.movigestion.platform.profilles.interfaces.rest.transform.ProfileResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/profiles", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Profiles", description = "Profile Management Endpoints")
public class ProfilesController {
    private final ProfileCommandService profileCommandService;
    private final ProfileQueryService profileQueryService;

    public ProfilesController(ProfileCommandService profileCommandService, ProfileQueryService profileQueryService) {
        this.profileCommandService = profileCommandService;
        this.profileQueryService = profileQueryService;
    }

    /**
     * Create a new Profile
     * @param resource Create Profile Resource including the profile data
     * @return Profile Resource if created, otherwise 400
     */
    @PostMapping
    public ResponseEntity<ProfileResource> createProfile(@RequestBody CreateProfileResource resource) {
        CreateProfileCommand createProfileCommand = CreateProfileCommandFromResourceAssembler.toCommandFromResource(resource);
        var profileId = profileCommandService.handle(createProfileCommand);
        if (profileId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);

        if (profile.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return new ResponseEntity<>(profileResource, HttpStatus.CREATED);
    }

    /**
     * Get Profile by Identifier
     * @param profileId the given Profile Identifier
     * @return Profile Resource if found, otherwise 404
     */
    @GetMapping("/{profileId}")
    public ResponseEntity<ProfileResource> getProfileById(@PathVariable Long profileId) {
        var getProfileByIdQuery = new GetProfileByIdQuery(profileId);
        var profile = profileQueryService.handle(getProfileByIdQuery);
        if (profile.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var profileResource = ProfileResourceFromEntityAssembler.toResourceFromEntity(profile.get());
        return ResponseEntity.ok(profileResource);
    }
}
