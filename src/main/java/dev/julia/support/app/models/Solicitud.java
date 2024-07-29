package dev.julia.support.app.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Solicitud {

 
    @Id
 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private LocalDateTime fecha;
    private String tema;
    private String descripcion;
    private boolean completada;

    public Solicitud() {}

    
    public Solicitud(String nombre, LocalDateTime fecha, String tema, String descripcion, boolean completada) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.tema = tema;
        this.descripcion = descripcion;
        this.completada = completada;
    }

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }


    public Solicitud(Long id, String nombre, LocalDateTime fecha, String tema, String descripcion, boolean completada) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.tema = tema;
        this.descripcion = descripcion;
        this.completada = completada;
    }


  
}
