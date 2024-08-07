/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1.modelo.clases;

import java.io.Serializable;

/**
 *
 * @author creditos gonzalez
 */
public class Precio implements Serializable{
    private double cant;
    private boolean esNegociable;

    public Precio(double cant, boolean esNegociable) {
        this.cant = cant;
        this.esNegociable = esNegociable;
    }

    public double getCant() {
        return cant;
    }
    
    public String toString() {
        return cant+"";
    }

    public void setCant(double cant) {
        this.cant = cant;
    }

    public boolean isEsNegociable() {
        return esNegociable;
    }

    public void setEsNegociable(boolean esNegociable) {
        this.esNegociable = esNegociable;
    }
    
    
}
