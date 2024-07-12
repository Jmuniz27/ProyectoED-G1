/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1.modelo.clases;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author isabella
 */
public class AccidenteServicios implements Serializable{
    private LocalDate fecha;
    private String descrip;
    
    public AccidenteServicios(LocalDate fecha, String descrip){
        this.fecha = fecha;
        this.descrip = descrip;
    }
    
    public LocalDate getFecha(){
        return fecha;
        
    }
    
    public String getDescrip(){
        return descrip;
    }
}
