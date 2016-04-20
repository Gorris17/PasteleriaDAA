/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleriadaa;

import java.util.LinkedList;

/**
 *
 * @author hola
 */
public class Nodo implements Comparable <Nodo>{
    private     int                     nivel;
    private     int                     beneficio;
    private     int                     peso;
    private     LinkedList<Integer>     sol;
    private     int                     nombre;

    public Nodo(int nivel, int beneficio, int peso, int nombre) {
        this.nivel = nivel;
        this.beneficio = beneficio;
        this.peso = peso;
        this.nombre = nombre;
        this.sol = new LinkedList<>();
    }

    public Nodo() {
        this(0,0,0,0);
    }
    
    public Nodo(Nodo n) {
        this.nivel = n.nivel;
        this.beneficio = n.beneficio;
        this.peso = n.peso;
        this.sol = n.sol;
    }
    

    @Override
    public int compareTo(Nodo t) {
        return (this.beneficio + this.peso) - (t.getBeneficio() + t.getPeso());
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(int beneficio) {
        this.beneficio = beneficio;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public LinkedList<Integer> getSol() {
        return sol;
    }

    public void setSol(LinkedList<Integer> sol) {
        this.sol = sol;
    }
    
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
    
    
}
