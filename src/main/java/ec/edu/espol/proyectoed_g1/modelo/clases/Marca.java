/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1.modelo.clases;

import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;

/**
 *
 * @author isabella
 */
public class Marca {
    private String nombre;
    private LinkedList<String> modelos = new LinkedList<>();
    public Marca(String nombre, LinkedList<String> modelos){
        this.nombre = nombre;
        this.modelos = modelos;
    }
    public Marca(String nombre){
        this.nombre = nombre;
    }
    public LinkedList<String> getModelos(){
        return modelos;
    }
    public String getNombre(){
        return nombre;
    }
    
    public String toString(){
        return nombre;
    }
}
