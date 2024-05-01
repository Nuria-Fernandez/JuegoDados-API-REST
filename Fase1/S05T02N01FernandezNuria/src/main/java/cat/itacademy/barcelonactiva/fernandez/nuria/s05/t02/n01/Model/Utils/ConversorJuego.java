package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Utils;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.DTO.JuegoDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain.JuegoEntity;
import org.springframework.stereotype.Component;

@Component
public class ConversorJuego {

    public static JuegoDTO convertirDesdeJuegoEntity(JuegoEntity juegoEntity){
        JuegoDTO juegoDTO = new JuegoDTO();

        juegoDTO.setIdJuego(juegoEntity.getIdJuego());
        juegoDTO.setDado1(juegoEntity.getDado1());
        juegoDTO.setDado2(juegoEntity.getDado2());
        juegoDTO.setGanada(juegoEntity.isGanada());

        return juegoDTO;
    }
    public static JuegoEntity convertirParaJuegoEntity(JuegoDTO juegoDTO){
        JuegoEntity juegoEntity = new JuegoEntity();

        juegoEntity.setIdJuego(juegoDTO.getIdJuego());
        juegoEntity.setDado1(juegoDTO.getDado1());
        juegoEntity.setDado2(juegoDTO.getDado2());
        juegoEntity.setGanada(juegoDTO.isGanada());

        return juegoEntity;
    }
}
