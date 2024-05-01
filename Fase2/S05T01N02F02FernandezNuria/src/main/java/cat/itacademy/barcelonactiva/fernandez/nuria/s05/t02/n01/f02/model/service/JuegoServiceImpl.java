package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.service;

import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.exceptions.JugadorNoExiste;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.exceptions.PartidasNoEncontradas;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain.JuegoEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.domain.JugadorEntity;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.dto.JuegoDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.repository.JuegoRepository;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.repository.JugadorRepository;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.service.Interfaces.JuegoService;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.utils.ConversorJuego;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class JuegoServiceImpl implements JuegoService {
    @Autowired
    private JuegoRepository juegoRepository;
    @Autowired
    private JugadorRepository jugadorRepository;

    @Override
    public JuegoDTO jugarJuego(String id) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);
        JuegoEntity juegoEntity= new JuegoEntity();
        if(optionalJugadorEntity.isPresent()){

            JugadorEntity jugadorEntity = optionalJugadorEntity.get();

            partida(juegoEntity);//Se le da valor a los dados

            jugadorEntity.agregarPartida(juegoEntity);//se añade el juego a la lista de juegos del jugador
            juegoRepository.save(juegoEntity);
            jugadorRepository.save(jugadorEntity);//guardamos el juego en la bbdd
            return ConversorJuego.convertirDesdeJuegoEntity(juegoEntity);
        }else{
            throw new JugadorNoExiste("No se ha econtrado al jugador con ID " + id);
        }

    }

    @Override
    @Transactional
    public String borrarJuegos(String id) {
        Optional<JugadorEntity> optionalJugadorEntity = jugadorRepository.findById(id);
        JugadorEntity jugador = optionalJugadorEntity.get();
        List<JuegoEntity> listaJuegos = jugador.getListaPartidas();
        if (optionalJugadorEntity.isPresent() && !listaJuegos.isEmpty()) {

            juegoRepository.deleteAll(listaJuegos);
            listaJuegos.clear();
            jugadorRepository.save(jugador);
            return "Se han eliminado las partidas del jugador con el ID " + id;
        } else if(listaJuegos.isEmpty()){
            throw new PartidasNoEncontradas("No se han encontrado partidas para el jugador con ID " + id);
        }else{
            throw new JugadorNoExiste("No se ha encontrado el jugador con el ID " + id);
        }
    }

    @Override
    public List<JuegoDTO> listaJugadasByJugador(String id) {
        Optional<JugadorEntity>optionalJugadorEntity = jugadorRepository.findById(id);
        List<JuegoEntity> listaPartidas = optionalJugadorEntity.get().getListaPartidas();
        if(optionalJugadorEntity.isPresent() && !listaPartidas.isEmpty()){

            return listaPartidas.stream().map(ConversorJuego::convertirDesdeJuegoEntity).collect(Collectors.toList());
        }else if(listaPartidas.isEmpty()){
            throw new PartidasNoEncontradas("No se han encontrado partidas para el jugador con ID " + id);
        }else{
            throw new JugadorNoExiste("No se ha encontrado el jugador con el ID " + id);
        }
    }
    public void partida(JuegoEntity juegoEntity){
        Random random = new Random();
        int dado1 = random.nextInt(6)+1;
        int dado2 = random.nextInt(6)+1;
        juegoEntity.setDado1(dado1);
        juegoEntity.setDado2(dado2);
        juegoEntity.setPartidaGanada(juegoEntity.calcularPartidaGanada());

    }
}
