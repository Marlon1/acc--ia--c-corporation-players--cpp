package Estructuras;

public class Arista {
    private String nombre;
    private double tiempoServicio;
    private double tiempoCruce;
    private boolean recorrido;
    
    public Arista(String nombre,double tiempoCruce,double tiempoServicio){
        this.nombre=nombre;
        this.tiempoCruce=tiempoCruce;
        this.tiempoServicio=tiempoServicio;
        this.recorrido=false;
    }
    public double getTiempoServicio() {
        return tiempoServicio;
    }
    public void setTiempoServicio(double tiempoServicio) {
        this.tiempoServicio = tiempoServicio;
    }
    public double getTiempoCruce() {
        return tiempoCruce;
    }
    public void setTiempoCruce(double tiempoCruce) {
        this.tiempoCruce = tiempoCruce;
    }
    public boolean isRecorrido() {
        return recorrido;
    }
    public void setRecorrido(boolean recorrido) {
        this.recorrido = recorrido;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
