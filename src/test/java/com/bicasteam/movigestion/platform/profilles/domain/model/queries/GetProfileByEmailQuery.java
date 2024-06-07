package com.bicasteam.movigestion.platform.profilles.domain.model.queries;

import com.bicasteam.movigestion.platform.profilles.domain.model.valueobjects.EmailAddress;

public record GetProfileByEmailQuery(EmailAddress emailAddress) {
}
