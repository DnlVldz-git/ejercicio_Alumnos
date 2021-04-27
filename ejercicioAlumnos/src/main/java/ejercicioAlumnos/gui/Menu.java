/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author dani
 */
public class Menu extends JMenuBar{
    private JMenu menuAlumnos;
    private JMenu menuAyuda;
    private JMenuItem nuevo;
    private JMenuItem borrar;
    private JMenuItem guardar;
    private JMenuItem salir;
    private JMenuItem acercaDe;
    
    public Menu(){
        this.menuAlumnos = new JMenu("Alumnos");
        this.menuAyuda = new JMenu("Ayuda");
        this.nuevo = new JMenuItem("Nuevo Estudiante");
        this.borrar = new JMenuItem("Borrar Estudiante");
        this.guardar = new JMenuItem("Guardar");
        this.salir = new JMenuItem("Salir");
        this.acercaDe = new JMenuItem("Acerca de");
        
        menuAlumnos.add(nuevo);
        menuAlumnos.add(borrar);
        menuAlumnos.add(guardar);
        menuAlumnos.add(salir);
        menuAyuda.add(acercaDe);
        
        super.add(this.menuAlumnos);
        super.add(menuAyuda);
    }

    public JMenuItem getNuevo() {
        return nuevo;
    }

    public JMenuItem getGuardar() {
        return guardar;
    }        

    public void setNuevo(JMenuItem nuevo) {
        this.nuevo = nuevo;
    }

    public JMenuItem getSalir() {
        return salir;
    }

    public void setSalir(JMenuItem salir) {
        this.salir = salir;
    }

    public JMenuItem getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(JMenuItem acercaDe) {
        this.acercaDe = acercaDe;
    }

    public JMenuItem getBorrar() {
        return borrar;
    }
    
    
    
}
