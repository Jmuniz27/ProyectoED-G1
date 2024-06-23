/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;

/**
 *
 * @author creditos gonzalez
 */
public class Historial{
    private LinkedList<Accidente> accidentes;
    private LinkedList<Mantenimiento> mantenimiento;

    public Historial(LinkedList<Accidente> accidentes, LinkedList<Mantenimiento> mantenimiento) {
        this.accidentes = accidentes;
        this.mantenimiento = mantenimiento;
    }

    public LinkedList<Accidente> getAccidentes() {
        return accidentes;
    }

    public void setAccidentes(LinkedList<Accidente> accidentes) {
        this.accidentes = accidentes;
    }

    public LinkedList<Mantenimiento> getMantenimiento() {
        return mantenimiento;
    }

    public void setMantenimiento(LinkedList<Mantenimiento> mantenimiento) {
        this.mantenimiento = mantenimiento;
    }
    
    
}
