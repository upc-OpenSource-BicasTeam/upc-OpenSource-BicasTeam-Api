package com.bicasteam.movigestion.platform.profilles.application.internal.commandservices;

import org.springframework.stereotype.Service;

@Service
public class ProfileCommandServiceImpl {
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
        var profile = new Profile(command.firstName(), command.lastName(), command.email(), command.street(), command.number(), command.city(), command.country());
        profileRepository.save(profile);
        return profile.getId();
    }
}


public class ProfileCommandServiceImpl implements ProfileCommandService {

}
