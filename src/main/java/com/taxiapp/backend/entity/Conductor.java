package com.taxiapp.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "conductores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Conductor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehiculo;

    private String placas;

    private Double latitud;

    private Double longitud;

    private Boolean disponible;

    private Double calificacion;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}