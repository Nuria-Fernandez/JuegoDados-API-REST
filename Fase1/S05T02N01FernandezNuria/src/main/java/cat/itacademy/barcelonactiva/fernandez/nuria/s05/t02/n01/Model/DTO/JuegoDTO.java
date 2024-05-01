package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(builderMethodName = "crearJuegoDTO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JuegoDTO {
    private int idJuego;
    private int dado1;
    private int dado2;
    private boolean ganada;
}
