package com.taxiapp.backend.repository;

import com.taxiapp.backend.entity.Viaje;
import com.taxiapp.backend.enums.EstadoViaje;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository
        extends JpaRepository<Viaje, Long> {
                List<Viaje> findByEstado(EstadoViaje estado);
}