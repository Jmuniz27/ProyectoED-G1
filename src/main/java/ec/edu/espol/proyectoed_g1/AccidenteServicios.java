/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author isabella
 */
public class AccidenteServicios{
    private LocalDate fecha;
    private String descrip;
    
    public AccidenteServicios(LocalDate fecha, String descrip){
        this.fecha = fecha;
        this.descrip = descrip;
    }
}
