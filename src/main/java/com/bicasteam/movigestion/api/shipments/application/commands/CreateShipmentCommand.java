package com.bicasteam.movigestion.api.shipments.application.commands;

import java.time.LocalDateTime;

public record CreateShipmentCommand(
        String idUser,
        String destiny,
        String description,
        DateTimeContainer dateTime,
        String status
) {
}


