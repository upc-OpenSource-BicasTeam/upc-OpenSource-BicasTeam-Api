package com.bicasteam.movigestion.api.iam.domain.services;

import com.bicasteam.movigestion.api.iam.domain.model.commands.CreateUserCommand;
import com.bicasteam.movigestion.api.iam.domain.model.entities.User;

import java.util.Optional;

public interface UserCommandService {
    Optional<User> handle(CreateUserCommand command);
}
