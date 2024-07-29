package dev.julia.support.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.julia.support.app.models.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
   
    List<Solicitud> findByNombreContainingIgnoreCase(String nombre);
}
