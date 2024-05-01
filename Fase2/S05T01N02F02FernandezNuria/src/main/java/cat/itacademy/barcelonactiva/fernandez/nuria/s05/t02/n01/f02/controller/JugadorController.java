package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.controller;


import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.dto.JuegoDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.dto.JugadorDTO;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.service.JuegoServiceImpl;
import cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.service.JugadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class JugadorController {
    @Autowired
    JugadorServiceImpl jugadorService;
    @Autowired
    JuegoServiceImpl juegoService;

    @PostMapping("/crear")
    ResponseEntity<JugadorDTO> crearJugador(@RequestBody JugadorDTO jugadorDTO) {//Le pongo <?> porque devuelve dos ResponseEntity diferentes

            JugadorDTO jugadorDTO1 = jugadorService.crear(jugadorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(jugadorDTO1);//Devuelve un DTO
    }

    @PutMapping("/actualizar/{id}")
    ResponseEntity<JugadorDTO> actualzarJugador(@PathVariable String id, @RequestBody JugadorDTO jugadorDTO) {

            JugadorDTO jugadorDTO1 = jugadorService.actualizar(id, jugadorDTO);
            return ResponseEntity.ok(jugadorDTO1);//puedo usar solo ok, sin mostrar los atributos del abjeto actualizado

    }

    @PostMapping("/{id}/partidas")//un jugador/a específic realitza una tirada dels daus.
    public ResponseEntity<JuegoDTO> jugarPartida(@PathVariable String id) {

            JuegoDTO juegoDTO = juegoService.jugarJuego(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(juegoDTO);
    }

    @DeleteMapping("/{id}/eliminarPartidas")
    public ResponseEntity<String> eliminarPartidas(@PathVariable String id) {

            String mensaje = juegoService.borrarJuegos(id);
            return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/{id}/borrarJugador")
    public ResponseEntity<String> eliminarJugador(@PathVariable String id) {

            String mensaje = jugadorService.borrar(id);
            return ResponseEntity.ok(mensaje);

    }

    @GetMapping("/mostrarListadoPorcentajeJugador")
    public ResponseEntity<List<JugadorDTO>> mostrarListadoPorcentajeMedio() {

            List<JugadorDTO> listaJugadores = jugadorService.getAllconPorcentajePorJugador();
            return ResponseEntity.ok(listaJugadores);
    }

    @GetMapping("/{id}/mostrarJugadasPorJugador")
    public ResponseEntity<List<JuegoDTO>> partidasPorJugador(@PathVariable String id) {

            List<JuegoDTO> listaJuegos = juegoService.listaJugadasByJugador(id);
            return ResponseEntity.ok(listaJuegos);
    }

    @GetMapping("/ranking")
    public ResponseEntity<Double> porcentajeMedioTodosJugadores() {

            double porcentajeMedioExito = jugadorService.porcentajeMedioExito();
            return ResponseEntity.ok(porcentajeMedioExito);
    }

    @GetMapping("/ranking/loser")
    public ResponseEntity<JugadorDTO> peorPorcentaje() {

            JugadorDTO jugadorDTO = jugadorService.peorPorcentajeExito();
            return ResponseEntity.ok(jugadorDTO);
    }

    @GetMapping("/ranking/winner")
    public ResponseEntity<JugadorDTO> mejorPorcentaje() {

            JugadorDTO jugadorDTO = jugadorService.mejorPorcentajeExito();
            return ResponseEntity.ok(jugadorDTO);
    }
}


