/*
Crear una clase Ahorcado (como el juego), la cual deberá contener
como atributos, un vector con la palabra a buscar, la cantidad de letras encontradas y
la cantidad jugadas máximas que puede realizar el usuario
 */
package Entidad;

public class Ahorcado {
    private char [] palabraABuscar;     
    private int cantidadLetrasEncontradas;
    private int jugadasMaximas;

    public Ahorcado() {
    }

    public Ahorcado(char[] palabraABuscar, int cantidadLetrasEncontradas, int jugadasMaximas) {
        this.palabraABuscar = palabraABuscar;
        this.cantidadLetrasEncontradas = cantidadLetrasEncontradas;
        this.jugadasMaximas = jugadasMaximas;
    }

    public char[] getpalabraABuscar() {
        return palabraABuscar;
    }

    public int getCantidadLetrasEncontradas() {
        return cantidadLetrasEncontradas;
    }

    public int getJugadasMaximas() {
        return jugadasMaximas;
    }

    public void setPalabraABuscar(char[] palabraABuscar) {
        this.palabraABuscar = palabraABuscar;
    }

    public void setCantidadLetrasEncontradas(int cantidadLetrasEncontradas) {
        this.cantidadLetrasEncontradas = cantidadLetrasEncontradas;
    }

    public void setJugadasMaximas(int jugadasMaximas) {
        this.jugadasMaximas = jugadasMaximas;
    }
    
    
}
