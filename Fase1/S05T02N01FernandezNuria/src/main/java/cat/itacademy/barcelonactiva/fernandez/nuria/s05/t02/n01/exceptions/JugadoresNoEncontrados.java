package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.exceptions;

public class JugadoresNoEncontrados extends RuntimeException{
    public JugadoresNoEncontrados(String mensaje){
        super(mensaje);
    }
}
