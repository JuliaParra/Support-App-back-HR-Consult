package dev.julia.support.app.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.julia.support.app.models.Solicitud;
import dev.julia.support.app.services.SolicitudService;

@RestController
@RequestMapping("/api/solicitud")
@CrossOrigin(origins = "http://localhost:5173")
public class SolicitudControllers {

    private final SolicitudService solicitudService;

    // Constructor con inyección de dependencia
    public SolicitudControllers(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<Solicitud> getSolicitudes(@RequestParam(required = false) Long id, 
                                          @RequestParam(required = false) String nombre) {
        if (id != null) {
            // Filtra por ID si se proporciona
            Solicitud solicitud = solicitudService.findById(id);
            return solicitud != null ? List.of(solicitud) : List.of();
        } else if (nombre != null && !nombre.isEmpty()) {
            // Filtra por nombre si se proporciona
            return solicitudService.findByNombre(nombre);
        } else {
            // Devuelve todas las solicitudes si no se proporcionan filtros
            return solicitudService.findAll();
        }
    }
    
    @PostMapping
    public Solicitud createSolicitud(@RequestBody Solicitud solicitud) {
        solicitud.setFecha(LocalDateTime.now());
        return solicitudService.save(solicitud);
    }

    @PutMapping("/{id}")
    public Solicitud updateSolicitud(@PathVariable Long id, @RequestBody Solicitud solicitud) {
        Solicitud existingSolicitud = solicitudService.findById(id);
        if (existingSolicitud != null) {
            existingSolicitud.setNombre(solicitud.getNombre());
            existingSolicitud.setTema(solicitud.getTema());
            existingSolicitud.setDescripcion(solicitud.getDescripcion());
            existingSolicitud.setCompletada(solicitud.isCompletada());
            return solicitudService.save(existingSolicitud);
        }
        return null; // Considera lanzar una excepción o retornar un 404
    }

    @DeleteMapping("/{id}")
    public void deleteSolicitud(@PathVariable Long id) {
        solicitudService.deleteById(id);
    }
}
