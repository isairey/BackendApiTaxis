package com.taxiapp.backend.controller;

import com.taxiapp.backend.entity.Viaje;
import com.taxiapp.backend.enums.EstadoViaje;
import com.taxiapp.backend.repository.ViajeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/viajes")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ViajeController {

    private final ViajeRepository viajeRepository;

    @GetMapping
    public List<Viaje> listar() {
        return viajeRepository.findAll();
    }

    @PostMapping
    public Viaje crear(@RequestBody Viaje viaje) {

        viaje.setEstado(EstadoViaje.PENDIENTE);
        viaje.setFecha(LocalDateTime.now());

        return viajeRepository.save(viaje);
    }

    @PutMapping("/{id}/aceptar")
    public Viaje aceptar(@PathVariable Long id) {

        Viaje viaje = viajeRepository.findById(id).orElseThrow();

        viaje.setEstado(EstadoViaje.ACEPTADO);

        return viajeRepository.save(viaje);
    }

    @PutMapping("/{id}/finalizar")
    public Viaje finalizar(@PathVariable Long id) {

        Viaje viaje = viajeRepository.findById(id).orElseThrow();

        viaje.setEstado(EstadoViaje.FINALIZADO);

        return viajeRepository.save(viaje);
    }
}