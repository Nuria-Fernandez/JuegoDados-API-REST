package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.dto;


import java.time.LocalDateTime;


public class JugadorDTO {
    private String id;
    private String nombreJugador;
    private LocalDateTime fechaRegistro;
    private float porcentaje;
    public JugadorDTO(){

    }
    public JugadorDTO(String nombreJugador, LocalDateTime fechaRegistro ){

        this.nombreJugador = nombreJugador;
        this.fechaRegistro = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }
}

