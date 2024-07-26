

package dev.julia.support.app.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.julia.support.app.models.Solicitud;
import dev.julia.support.app.services.SolicitudService;

@RestController
@RequestMapping("/api/solicitud")
@CrossOrigin(origins = "http://localhost:8080")
public class SolicitudControllers {


    @Autowired
    public void SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @GetMapping
    public List<Solicitud> getAllSolicitudes() {
        return solicitudService.findAll();
    }

    @GetMapping("/{id}")
    public Solicitud getSolicitudById(@PathVariable Long id) {
        return solicitudService.findById(id);
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
        return null; 
    }

    @DeleteMapping("/{id}")
    public void deleteSolicitud(@PathVariable Long id) {
        solicitudService.deleteById(id);
    }

    
    public SolicitudControllers(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    private SolicitudService solicitudService = null;
}