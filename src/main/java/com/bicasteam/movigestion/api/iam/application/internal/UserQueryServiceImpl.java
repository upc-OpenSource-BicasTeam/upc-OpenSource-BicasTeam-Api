package com.bicasteam.movigestion.api.iam.application.internal;

import com.bicasteam.movigestion.api.iam.domain.model.entities.User;
import com.bicasteam.movigestion.api.iam.domain.services.UserQueryService;
import com.bicasteam.movigestion.api.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;

    public UserQueryServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}