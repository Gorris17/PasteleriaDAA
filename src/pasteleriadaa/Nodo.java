/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleriadaa;

/**
 *
 * @author FernandoC
 */
public class Nodo implements Comparable <Nodo>{
    private int beneficio;
    private int nivel=0;
    private int pastelero;
    
    
    public Nodo(int pas){
        this.pastelero=pas;
        beneficio=0;
        
    }
    
    public void eliminarNodo(Nodo n){
        
    }

    @Override
    public int compareTo(Nodo o) {
     return beneficio;
    }
    
    
}
