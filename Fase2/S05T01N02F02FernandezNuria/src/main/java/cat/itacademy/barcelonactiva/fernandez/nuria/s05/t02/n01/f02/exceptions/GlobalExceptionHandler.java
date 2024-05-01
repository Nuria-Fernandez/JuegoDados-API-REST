package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(JugadorExistente.class)
    public ResponseEntity<String> handleJugadorExistente(JugadorExistente ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(JugadorNoExiste.class)
    public ResponseEntity<String> handleJugadorNoExiste(JugadorNoExiste ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(PartidasNoEncontradas.class)
    public ResponseEntity<String> handlePartidasNoEncontradas(PartidasNoEncontradas ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(JugadoresNoEncontrados.class)
    public ResponseEntity<String> handleJugadoresNoEncontrados(JugadoresNoEncontrados ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
