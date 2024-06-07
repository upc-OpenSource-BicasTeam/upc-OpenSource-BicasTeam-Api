package com.bicasteam.movigestion.api.vehicles.application.commands;

public record CreateVehicleCommand(Long idUser, String licensePlate, String modelSerialNumber) {
}
