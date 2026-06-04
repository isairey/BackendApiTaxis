package com.taxiapp.backend.repository;

import com.taxiapp.backend.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConductorRepository extends JpaRepository<Conductor, Long> {
}