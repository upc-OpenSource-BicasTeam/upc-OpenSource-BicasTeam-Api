package com.bicasteam.movigestion.platform.profilles.infraestructure.persistence.jpa.repositories;

import com.bicasteam.movigestion.platform.profilles.domain.model.aggregates.Profile;
import com.bicasteam.movigestion.platform.profilles.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    Optional<Profile> findByEmail(EmailAddress emailAddress);
}
