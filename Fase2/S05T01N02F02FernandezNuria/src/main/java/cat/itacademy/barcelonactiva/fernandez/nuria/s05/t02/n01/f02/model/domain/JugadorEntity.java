package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain;


import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Document(collection = "Jugador")
public class JugadorEntity {
    @Id
    private String id;
    @Field(name = "Fecha_Ocurrencia")
    private LocalDateTime fechaRegistro;
    @Field(name = "Nombre_Jugador")
    private String nombreJugador;
    @DBRef
    private List<JuegoEntity> listaPartidas;

    public JugadorEntity(){
        this.listaPartidas = new ArrayList<>();

    }
    public JugadorEntity(String id, LocalDateTime fechaRegistro, String nombreJugador, List<JuegoEntity> listaPartidas){
        this.id = id;
        this.fechaRegistro = LocalDateTime.now();
        this.nombreJugador = nombreJugador;
        this.listaPartidas = listaPartidas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public List<JuegoEntity> getListaPartidas() {
        return listaPartidas;
    }

    public void setListaPartidas(List<JuegoEntity> listaPartidas) {
        this.listaPartidas = listaPartidas;
    }

    public void agregarPartida(JuegoEntity juego){
        listaPartidas.add(juego);

    }
    public float porcentaje(){
        float porcentajeExito = 0.0f;
        if(listaPartidas != null && !listaPartidas.isEmpty()){
            long totalPartidas = listaPartidas.size();
            long partidasGanadas = listaPartidas.stream().filter(JuegoEntity::calcularPartidaGanada).count();
            porcentajeExito = (float) partidasGanadas/totalPartidas * 100;
        }
        return porcentajeExito;
    }
}
