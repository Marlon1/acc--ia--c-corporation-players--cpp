package Estructuras;

public class Arista {
    private int tiempoServicio;
    private int tiempoCruce;
    private boolean recorrido;
    
    
    public int getTiempoServicio() {
        return tiempoServicio;
    }
    public void setTiempoServicio(int tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }
    public int getTiempoCruce() {
        return tiempoCruce;
    }
    public void setTiempoCruce(int tiempoCruce) {
        this.tiempoCruce = tiempoCruce;
    }
    public boolean isRecorrido() {
        return recorrido;
    }
    public void setRecorrido(boolean recorrido) {
        this.recorrido = recorrido;
    }
}
