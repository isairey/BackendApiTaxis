package com.taxiapp.backend.repository;

import com.taxiapp.backend.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository
        extends JpaRepository<Viaje, Long> {
}