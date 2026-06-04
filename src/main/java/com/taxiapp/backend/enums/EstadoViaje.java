package com.taxiapp.backend.enums;

public enum EstadoViaje {

    PENDIENTE,     // esperando conductor
    ACEPTADO,      // conductor aceptó
    EN_CAMINO,     // conductor va por pasajero
    EN_CURSO,      // pasajero ya va dentro del taxi
    FINALIZADO,
    CANCELADO
}