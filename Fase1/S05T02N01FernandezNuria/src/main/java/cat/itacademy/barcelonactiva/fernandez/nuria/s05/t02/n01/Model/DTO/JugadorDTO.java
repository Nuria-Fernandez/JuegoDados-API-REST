package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder(builderMethodName = "crearJugadorDTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JugadorDTO {
    private int pk_IdJugador;
    private String nombreJugador;
    private float porcentaje;

}
