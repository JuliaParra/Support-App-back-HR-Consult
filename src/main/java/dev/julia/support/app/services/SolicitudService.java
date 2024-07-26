package dev.julia.support.app.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.julia.support.app.models.Solicitud;
import dev.julia.support.app.repositories.SolicitudRepository;



@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;


    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;

    }
    
    public List<Solicitud> findAll() {
        return solicitudRepository.findAll();
    }

    public Solicitud findById(Long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    public Solicitud save(Solicitud solicitud) {
        return solicitudRepository.save(solicitud);
    }

    public void deleteById(Long id) {
        solicitudRepository.deleteById(id);
    }
}
