package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.exceptions;

public class JugadorExistente extends RuntimeException{
    public JugadorExistente(String mensaje){
        super(mensaje);
    }
}
