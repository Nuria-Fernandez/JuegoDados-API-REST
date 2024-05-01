package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Service.Interfaces;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.DTO.JuegoDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Domain.JuegoEntity;

import java.util.List;

public interface JuegoService {

    JuegoDTO jugarJuego(int id);
    String borrarJuegos(int id);
    List<JuegoDTO> listaJugadasByJugador(int id);
    void partida(JuegoEntity juegoEntity);

}
