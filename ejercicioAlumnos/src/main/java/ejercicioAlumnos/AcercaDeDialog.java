/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author dani
 */
public class AcercaDeDialog extends JDialog{
    private JPanel pnl;
    private JLabel lbl;
    private JLabel lbl2;
    
    public AcercaDeDialog(){
        super.setSize(500, 200);
        this.pnl = new JPanel();
        this.lbl = new JLabel("Pues este es el Acerca De, ps \nHace lo de alumnos y así, saludos crack");
        ImageIcon icon = new ImageIcon("geek-----.gif");
        this.lbl2 = new JLabel(icon);
        
        this.pnl.add(this.lbl);
        this.pnl.add(this.lbl2);
        
        add(pnl);
    }
    
}
