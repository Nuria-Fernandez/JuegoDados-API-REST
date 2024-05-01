package cat.itacademy.barcelonactiva.fernandez.nuria.s05.t02.n01.f02.model.dto;





public class JuegoDTO {
    private String id;
    private int dado1;
    private int dado2;
    private boolean ganada;

    public JuegoDTO(){

    }
    public JuegoDTO(String id, int dado1, int dado2, boolean ganada){
        this.id = id;
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.ganada = ganada;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public boolean isGanada() {
        return ganada;
    }

    public void setGanada(boolean ganada) {
        this.ganada = ganada;
    }
}