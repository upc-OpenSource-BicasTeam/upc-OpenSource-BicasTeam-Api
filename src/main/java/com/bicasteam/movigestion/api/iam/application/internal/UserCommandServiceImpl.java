package com.bicasteam.movigestion.api.iam.application.internal;

import com.bicasteam.movigestion.api.iam.domain.model.commands.CreateUserCommand;
import com.bicasteam.movigestion.api.iam.domain.model.entities.User;
import com.bicasteam.movigestion.api.iam.domain.services.UserCommandService;
import com.bicasteam.movigestion.api.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;

    public UserCommandServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> handle(CreateUserCommand command) {
        var user = new User(command);
        userRepository.save(user);
        return Optional.of(user);
    }
}
