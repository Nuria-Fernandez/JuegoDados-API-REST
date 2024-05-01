package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.Service.Interfaces;


import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.Model.DTO.JugadorDTO;


import java.util.List;

public interface JugadorService {
    JugadorDTO crear(JugadorDTO jugadorDTO);
    JugadorDTO actualizar(int id, JugadorDTO jugadorDTO);
    String borrar(int id);
    List<JugadorDTO> getAll();
    List<JugadorDTO> getAllconPorcentajePorJugador();
    JugadorDTO findById(int id);
    double porcentajeMedioExito();
    JugadorDTO mejorPorcentajeExito();
    JugadorDTO peorPorcentajeExito();

}
