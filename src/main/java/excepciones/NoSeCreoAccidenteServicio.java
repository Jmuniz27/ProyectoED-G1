/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class NoSeCreoAccidenteServicio extends Exception {
    public NoSeCreoAccidenteServicio() {
        super("Por favor llene todos los campos.");
    }
    public NoSeCreoAccidenteServicio(String msg) {
        super(msg);
    }
}
