/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author isabella
 */
public class NoEsNumero extends Exception{
    public NoEsNumero() {
        super("No puede ser número");
    }
    public NoEsNumero(String msg) {
        super(msg);
    }
}
