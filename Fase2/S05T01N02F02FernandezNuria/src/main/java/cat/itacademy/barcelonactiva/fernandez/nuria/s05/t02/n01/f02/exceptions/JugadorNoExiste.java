package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.exceptions;

public class JugadorNoExiste extends RuntimeException{
    public JugadorNoExiste(String mensaje) {
        super(mensaje);
    }
}
