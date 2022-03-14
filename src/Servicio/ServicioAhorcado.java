package Servicio;

import Entidad.Ahorcado;
import java.util.Scanner;

public class ServicioAhorcado {
    
    Scanner leer = new Scanner(System.in);
    
    /* Metodo crearJuego(): le pide la palabra al usuario y cantidad de jugadas máxima.
****Con la palabra del usuario, pone la longitud de la palabra, como la longitud del vector.*******
Después ingresa la palabra en el vector, letra por letra, quedando cada letra de la
palabra en un índice del vector. Y también, guarda en cantidad de jugadas máximas,
el valor que ingresó el usuario y encontradas en 0.*/
    public Ahorcado crearJuego(){
        Ahorcado a = new Ahorcado();
        String palabra; 
        int largoPalabra;
        char [] palabraSecreta;
       
        System.out.println("Ingrese la palabra secreta");
        palabra = leer.next();
        largoPalabra=palabra.length();
        palabraSecreta = new char[largoPalabra];
        
        for(int i=0; i<largoPalabra; i++){           //lleno un vector con la palabra a buscar
            palabraSecreta[i]=palabra.charAt(i);      //convierto la cadena en un vector
        }
        a.setPalabraABuscar(palabraSecreta);         //seteo el atributo con el vector

        System.out.println("Ingrese la cantidad de jugadas máxima");
        a.setJugadasMaximas(leer.nextInt());
        
        a.setCantidadLetrasEncontradas(0);
      
        return a;
    }

    
// Método longitud(): muestra la longitud de la palabra que se debe encontrar  
    public void longitud(Ahorcado a){
        System.out.println("La longitud de la palabra es " + a.getpalabraABuscar().length);
    }
    
    
/*
Método buscar(letra): este método recibe una letra dada por el usuario y busca si la
letra ingresada es parte de la palabra o no. También informará si la letra estaba o no.
    */  
    public void buscar (Ahorcado a, char letra){
        boolean letraPertenece = false;
        int largoPalabra = a.getpalabraABuscar().length;
        char [] vector = a.getpalabraABuscar();
       
            for (int i=0; i<largoPalabra; i++){
                if (vector[i]==letra){
                   letraPertenece = true;
                                                                     //aumenta la cantidad de encontradas
                   a.setCantidadLetrasEncontradas(a.getCantidadLetrasEncontradas() + 1);//setea atributo  
                   System.out.println("La letra pertenece a la palabra");  
                }
            }
            
            if (!letraPertenece){
                System.out.println("La letra no pertenece a la palabra");
                                                         //disminuye cantidad de intentos
                a.setJugadasMaximas(a.getJugadasMaximas() - 1);   //setea atributo   
            }  
    }

/*
Método encontradas(letra): que reciba una letra ingresada por el usuario y muestre
cuantas letras han sido encontradas y cuantas le faltan. 
*****Este método además deberá devolver true si la letra estaba y false si la letra no estaba, ****
*****ya que, cada vez que se busque una letra que no esté, se le restará uno a sus oportunidades. ***   
    */    
    public void encontradas(Ahorcado a, char letra){
        System.out.println("Cantidad de letras encontradas: " + a.getCantidadLetrasEncontradas());
        System.out.println("Cantidad de letras que faltan: " + (a.getpalabraABuscar().length - a.getCantidadLetrasEncontradas()));
    }

//Método intentos(): para mostrar cuantas oportunidades le queda al jugador.
    public void intentos(Ahorcado a){
        if (a.getJugadasMaximas()>0){
            System.out.println("Cantidad de intentos restantes: " + a.getJugadasMaximas());
        } else {
            System.out.println("Lo sentimos, no hay más oportunidades");
        }
    }

/*
Método juego(): el método juego se encargará de llamar todos los métodos
previamente mencionados e informará cuando el usuario descubra toda la palabra o
se quede sin intentos. Este método se llamará en el main.    
    */    
    public void juego(){
        Ahorcado a = new Ahorcado();
        char letra;
        
        a = crearJuego();
        System.out.println("\n\n\n\n\n\n\n\n\n\n");    //limpiar la pantalla???
        
                                            //..y mientras no haya encontrado todas las letras    
        while (a.getJugadasMaximas()>0 && a.getCantidadLetrasEncontradas()!=a.getpalabraABuscar().length){ 
            System.out.println("Ingrese una letra");
            letra = leer.next().charAt(0);   //¡¡¡¡¡¡¡¡artilugio para que convierta el string en char!!!!!!!!
            
            longitud(a);
                   
            buscar(a, letra);
            
            encontradas(a, letra);  
            
            intentos(a);
            
            System.out.println("---------------------");
        }
    }
    
}
