package com.bicasteam.movigestion.platform.profilles.application.internal.commandservices;

import com.bicasteam.movigestion.platform.profilles.domain.model.aggregates.Profile;
import com.bicasteam.movigestion.platform.profilles.domain.model.commands.CreateProfileCommand;
import com.bicasteam.movigestion.platform.profilles.domain.model.valueobjects.EmailAddress;
import com.bicasteam.movigestion.platform.profilles.domain.services.ProfileCommandService;
import com.bicasteam.movigestion.platform.profilles.infraestructure.persistence.jpa.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl implements ProfileCommandService {
    private final ProfileRepository profileRepository;

    public ProfileCommandServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Long handle(CreateProfileCommand command) {
        var emailAddress = new EmailAddress(command.email());
        profileRepository.findByEmail(emailAddress).map(profile -> {
            throw new IllegalArgumentException("Profile with email "+ command.email() + "already exists");
        });
        var profile = new Profile(command.firstName(), command.lastName(), command.email(), command.street(), command.number(), command.city());
        profileRepository.save(profile);
        return profile.getId();
    }
}