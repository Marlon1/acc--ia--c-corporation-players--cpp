package Estructuras;

public class Arista {
    private float tiempoServicio;
    private float tiempoCruce;
    private boolean recorrido;
    
    
    public float getTiempoServicio() {
        return tiempoServicio;
    }
    public void setTiempoServicio(float tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }
    public float getTiempoCruce() {
        return tiempoCruce;
    }
    public void setTiempoCruce(float tiempoCruce) {
        this.tiempoCruce = tiempoCruce;
    }
    public boolean isRecorrido() {
        return recorrido;
    }
    public void setRecorrido(boolean recorrido) {
        this.recorrido = recorrido;
    }
}
