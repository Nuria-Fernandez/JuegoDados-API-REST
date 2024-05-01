package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder(builderMethodName = "crearJugador")
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="Jugador")
public class JugadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk_IdJugador;
    @Column(name="NombreJugador")
    private String nombreJugador;
    @Column(name="FechaRegistro")
    private LocalDateTime fechaRegistro = LocalDateTime.now();

    @OneToMany(mappedBy = "jugadorEntity", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<JuegoEntity> listaPartidas = new ArrayList<>();

    public void agregarPartida(JuegoEntity juego){
        if(listaPartidas.isEmpty()){
            listaPartidas = new ArrayList<>();
        }
            listaPartidas.add(juego);
    }
    public float porcentaje(){
        float porcentajeExito = 0.0f;
        if(listaPartidas != null & !listaPartidas.isEmpty()){
            long totalPartidas = listaPartidas.size();
            long partidasGanadas = listaPartidas.stream().filter(JuegoEntity::partidaGanada).count();
            porcentajeExito = (float) partidasGanadas/totalPartidas * 100;
        }
        return porcentajeExito;
    }
}
