package com.taxiapp.backend.entity;

import com.taxiapp.backend.enums.EstadoViaje;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "viajes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Viaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origen;

    private String destino;

    private Double costo;

    private Double distancia;

    private Double origenLat;

    private Double origenLng;

    private Double destinoLat;

    private Double destinoLng;

    @Enumerated(EnumType.STRING)
    private EstadoViaje estado;

    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "conductor_id")
    private Conductor conductor;
}