package com.bicasteam.movigestion.api.iam.interfaces.rest;

import com.bicasteam.movigestion.api.iam.domain.services.UserCommandService;
import com.bicasteam.movigestion.api.iam.domain.services.UserQueryService;
import com.bicasteam.movigestion.api.iam.interfaces.rest.resources.CreateUserResource;
import com.bicasteam.movigestion.api.iam.interfaces.rest.resources.UserResource;
import com.bicasteam.movigestion.api.iam.interfaces.rest.transform.CreateUserCommandFromResourceAssembler;
import com.bicasteam.movigestion.api.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(@RequestBody CreateUserResource createUserResource) {
        var command = CreateUserCommandFromResourceAssembler.toCommandFromResource(createUserResource);
        var user = userCommandService.handle(command);
        var userResource = user.map(UserResourceFromEntityAssembler::toResourceFromEntity);
        return new ResponseEntity<>(userResource.orElse(null), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResource> getUserById(@PathVariable Long id) {
        var user = userQueryService.findById(id);
        var userResource = user.map(UserResourceFromEntityAssembler::toResourceFromEntity);
        return userResource.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<UserResource>> getAllUsers() {
        var users = userQueryService.findAll();
        var userResources = users.stream()
                .map(UserResourceFromEntityAssembler::toResourceFromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResources);
    }
}