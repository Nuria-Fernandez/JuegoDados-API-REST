package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.utils;

import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain.JuegoEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.dto.JuegoDTO;

@Component
public class ConversorJuego {
    public static JuegoDTO convertirDesdeJuegoEntity(JuegoEntity juegoEntity){
        JuegoDTO juegoDTO = new JuegoDTO();

        juegoDTO.setId(juegoEntity.getId());
        juegoDTO.setDado1(juegoEntity.getDado1());
        juegoDTO.setDado2(juegoEntity.getDado2());
        juegoDTO.setGanada(juegoEntity.isPartidaGanada());

        return juegoDTO;
    }
    public static JuegoEntity convertirParaJuegoEntity(JuegoDTO juegoDTO){
        JuegoEntity juegoEntity = new JuegoEntity();

        juegoEntity.setId(juegoDTO.getId());
        juegoEntity.setDado1(juegoDTO.getDado1());
        juegoEntity.setDado2(juegoDTO.getDado2());
        juegoEntity.setPartidaGanada(juegoDTO.isGanada());

        return juegoEntity;
    }
}
