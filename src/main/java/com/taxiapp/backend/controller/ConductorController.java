package com.taxiapp.backend.controller;

import com.taxiapp.backend.entity.Conductor;
import com.taxiapp.backend.repository.ConductorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conductores")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ConductorController {

    private final ConductorRepository conductorRepository;

    @GetMapping
    public List<Conductor> listarConductores() {
        return conductorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Conductor obtenerConductor(@PathVariable Long id) {
        return conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));
    }

    @PostMapping
    public Conductor registrarConductor(@RequestBody Conductor conductor) {

        if (conductor.getDisponible() == null) {
            conductor.setDisponible(true);
        }

        if (conductor.getCalificacion() == null) {
            conductor.setCalificacion(5.0);
        }

        return conductorRepository.save(conductor);
    }

    @PutMapping("/{id}")
    public Conductor actualizarConductor(
            @PathVariable Long id,
            @RequestBody Conductor datos) {

        Conductor conductor = conductorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));

        conductor.setVehiculo(datos.getVehiculo());
        conductor.setPlacas(datos.getPlacas());
        conductor.setLatitud(datos.getLatitud());
        conductor.setLongitud(datos.getLongitud());
        conductor.setDisponible(datos.getDisponible());
        conductor.setCalificacion(datos.getCalificacion());

        return conductorRepository.save(conductor);
    }

    @DeleteMapping("/{id}")
    public String eliminarConductor(@PathVariable Long id) {

        conductorRepository.deleteById(id);

        return "Conductor eliminado correctamente";
    }
}