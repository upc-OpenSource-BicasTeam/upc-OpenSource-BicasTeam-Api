package com.bicasteam.movigestion.api.shipments.application.commands;

import java.time.LocalDateTime;

public record CreateShipmentCommand(Long idUserDestiny, String description, LocalDateTime dateTime, String status) {
}