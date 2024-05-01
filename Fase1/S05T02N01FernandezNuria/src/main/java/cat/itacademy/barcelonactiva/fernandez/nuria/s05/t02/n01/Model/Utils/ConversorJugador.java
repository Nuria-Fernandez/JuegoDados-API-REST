package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Utils;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.DTO.JugadorDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain.JugadorEntity;
import org.springframework.stereotype.Component;

@Component
public class ConversorJugador {

    public static JugadorDTO convertirDesdeJugadorEntity(JugadorEntity jugadorEntity){
        JugadorDTO jugadorDTO = new JugadorDTO();

        jugadorDTO.setPk_IdJugador(jugadorEntity.getPk_IdJugador());
        jugadorDTO.setNombreJugador(jugadorEntity.getNombreJugador());
        jugadorDTO.setPorcentaje(jugadorEntity.porcentaje());

        return jugadorDTO;
    }
    public static JugadorEntity convertirParaJugadorEntity(JugadorDTO jugadorDTO){
        JugadorEntity jugadorEntity = new JugadorEntity();

        jugadorEntity.setPk_IdJugador(jugadorDTO.getPk_IdJugador());
        jugadorEntity.setNombreJugador(jugadorDTO.getNombreJugador());

        return jugadorEntity;
    }
}
