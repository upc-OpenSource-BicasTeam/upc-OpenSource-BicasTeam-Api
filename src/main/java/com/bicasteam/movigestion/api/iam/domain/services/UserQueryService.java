package com.bicasteam.movigestion.api.iam.domain.services;

import com.bicasteam.movigestion.api.iam.domain.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    Optional<User> findById(Long id);
    List<User> findAll();
}
