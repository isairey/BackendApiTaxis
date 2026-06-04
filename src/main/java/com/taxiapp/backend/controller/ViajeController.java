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

    @GetMapping("/{id}")
public Viaje obtenerPorId(@PathVariable Long id) {

    return viajeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
}

@PutMapping("/{id}/iniciar")
public Viaje iniciar(@PathVariable Long id) {

    Viaje viaje = viajeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));

    viaje.setEstado(EstadoViaje.EN_CURSO);

    return viajeRepository.save(viaje);
}
@PutMapping("/{id}/cancelar")
public Viaje cancelar(@PathVariable Long id) {

    Viaje viaje = viajeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));

    viaje.setEstado(EstadoViaje.CANCELADO);

    return viajeRepository.save(viaje);
}
@DeleteMapping("/{id}")
public String eliminar(@PathVariable Long id) {

    viajeRepository.deleteById(id);

    return "Viaje eliminado correctamente";
}

@GetMapping("/pendientes")
public List<Viaje> pendientes() {

    return viajeRepository.findByEstado(
            EstadoViaje.PENDIENTE
    );
}

@GetMapping("/aceptados")
public List<Viaje> aceptados() {

    return viajeRepository.findByEstado(
            EstadoViaje.ACEPTADO
    );
}

@GetMapping("/encurso")
public List<Viaje> enCurso() {

    return viajeRepository.findByEstado(
            EstadoViaje.EN_CURSO
    );
}

@GetMapping("/finalizados")
public List<Viaje> finalizados() {

    return viajeRepository.findByEstado(
            EstadoViaje.FINALIZADO
    );
}

@GetMapping("/cancelados")
public List<Viaje> cancelados() {

    return viajeRepository.findByEstado(
            EstadoViaje.CANCELADO
    );
}


}