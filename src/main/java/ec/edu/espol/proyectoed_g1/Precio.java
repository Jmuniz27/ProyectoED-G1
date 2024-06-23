/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

/**
 *
 * @author creditos gonzalez
 */
public class Precio {
    private float cant;
    private boolean esNegociable;

    public Precio(float cant, boolean esNegociable) {
        this.cant = cant;
        this.esNegociable = esNegociable;
    }

    public float getCant() {
        return cant;
    }

    public void setCant(float cant) {
        this.cant = cant;
    }

    public boolean isEsNegociable() {
        return esNegociable;
    }

    public void setEsNegociable(boolean esNegociable) {
        this.esNegociable = esNegociable;
    }
    
    
}
