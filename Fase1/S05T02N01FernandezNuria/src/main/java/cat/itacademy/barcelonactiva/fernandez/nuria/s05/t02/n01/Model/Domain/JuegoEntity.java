package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder(builderMethodName = "crearJuego")
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Juego")
public class JuegoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idJuego;
    @Column(name="Fecha_ocurrencia")
    private LocalDate fechaOcurrencia = LocalDate.now();
    @Column(name="Dado_1")
    private int dado1;
    @Column(name="Dado_2")
    private int dado2;
    @Column(name="Resultado")
    private boolean ganada;

    @ManyToOne
    @JoinColumn(name="jugador_id")
    private JugadorEntity jugadorEntity;

    public boolean partidaGanada(){
        return dado1 + dado2 == 7;
    }




}
