    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1.modelo.clases;

import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;

/**
 *
 * @author creditos gonzalez
 */
public class Historial{
    private LinkedList<AccidenteServicios> reparaciones;
    private LinkedList<AccidenteServicios> mantenimientos;

    public Historial(LinkedList<AccidenteServicios> reparaciones, LinkedList<AccidenteServicios> mantenimientos) {
        this.reparaciones = reparaciones;
        this.mantenimientos = mantenimientos;
    }

    public LinkedList<AccidenteServicios> getAccidentes() {
        return reparaciones;
    }

    public void setAccidentes(LinkedList<AccidenteServicios> accidentes) {
        this.reparaciones = accidentes;
    }

    public LinkedList<AccidenteServicios> getMantenimiento() {
        return mantenimientos;
    }

    public void setMantenimiento(LinkedList<AccidenteServicios> mantenimiento) {
        this.mantenimientos = mantenimiento;
    }
    
    
}
