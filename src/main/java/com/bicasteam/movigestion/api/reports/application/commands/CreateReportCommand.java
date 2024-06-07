package com.bicasteam.movigestion.api.reports.application.commands;

import java.time.LocalDateTime;

public record CreateReportCommand(Long idUser, String type, String description, LocalDateTime dateTime) {
}
