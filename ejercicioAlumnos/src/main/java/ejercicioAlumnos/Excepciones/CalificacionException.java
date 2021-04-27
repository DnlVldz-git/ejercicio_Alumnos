/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.Excepciones;

import javax.swing.JOptionPane;

/**
 *
 * @author dani
 */
public class CalificacionException extends Exception {

    /**
     * Creates a new instance of <code>CalificacionException</code> without
     * detail message.
     */
    public CalificacionException() {
    }

    /**
     * Constructs an instance of <code>CalificacionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CalificacionException(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
}
