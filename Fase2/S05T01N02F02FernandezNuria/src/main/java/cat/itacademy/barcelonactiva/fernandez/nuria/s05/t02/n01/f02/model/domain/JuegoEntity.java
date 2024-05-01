package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain;


import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@Document(collection = "Juego")
public class JuegoEntity {
    @Id
    private String id;
    @Field(name="Fecha_Registro")
    private LocalDateTime fechaRegistro;
    @Field(name="Dado1")
    private int dado1;
    @Field(name="Dado2")
    private int dado2;
    @Field(name="Resultado")
    private boolean partidaGanada;
    @DBRef
    private JugadorEntity jugadorEntity;
    public JuegoEntity(){

    }
    public JuegoEntity(String id, LocalDateTime fechaRegistro, int dado1, int dado2, boolean partidaGanada){
        this.id = id;
        this.fechaRegistro = LocalDateTime.now();
        this.dado1 = dado1;
        this.dado2 = dado2;
        partidaGanada = calcularPartidaGanada();

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

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public boolean isPartidaGanada() {
        return partidaGanada;
    }

    public void setPartidaGanada(boolean partidaGanada) {
        this.partidaGanada = partidaGanada;
    }

    public JugadorEntity getJugadorEntity() {
        return jugadorEntity;
    }

    public void setJugadorEntity(JugadorEntity jugadorEntity) {
        this.jugadorEntity = jugadorEntity;
    }

    public boolean calcularPartidaGanada(){
        return dado1 + dado2 == 7;
    }



}
