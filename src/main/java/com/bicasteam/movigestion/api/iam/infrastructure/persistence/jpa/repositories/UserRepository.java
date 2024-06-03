package com.bicasteam.movigestion.api.iam.infrastructure.persistence.jpa.repositories;

import com.bicasteam.movigestion.api.iam.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
