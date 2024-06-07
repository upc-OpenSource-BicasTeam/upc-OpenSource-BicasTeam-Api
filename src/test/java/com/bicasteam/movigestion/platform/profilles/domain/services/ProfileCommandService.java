package com.bicasteam.movigestion.platform.profilles.domain.services;

import com.bicasteam.movigestion.platform.profilles.domain.model.commands.CreateProfileCommand;

public interface ProfileCommandService {
    Long handle(CreateProfileCommand command);
}