/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class ComboBoxSinEleccion extends Exception {
    public ComboBoxSinEleccion() {
        super("El combo box no tiene un elemento seleccionado");
    }
    public ComboBoxSinEleccion(String msg) {
        super(msg);
    }
}
