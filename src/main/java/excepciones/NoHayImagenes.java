/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class NoHayImagenes extends Exception{
    public NoHayImagenes() {
        super("Debe subir al menos una foto.");
    }
    public NoHayImagenes(String msg) {
        super(msg);
    }
}
