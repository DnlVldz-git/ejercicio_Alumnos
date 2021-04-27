/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.gui;

import ejercicioAlumnos.AlumnosTableModel;
import ejercicioAlumnos.Controller;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author dani
 */
public class BusquedaPanel extends JPanel{
    private JLabel lbl;
    private JTextField txtFld;
    private JButton btn;
    
    
    public BusquedaPanel(){
        super.setBackground(Color.PINK);
        
        this.lbl = new JLabel("Buscar");
        this.txtFld = new JTextField(20);
        this.btn = new JButton("Buscar");
                                
        super.add(this.lbl);
        super.add(this.txtFld);
        super.add(this.btn);
    }

    public JLabel getLbl() {
        return lbl;
    }

    public void setLbl(JLabel lbl) {
        this.lbl = lbl;
    }

    public JTextField getTxtFld() {
        return txtFld;
    }
    
    public String getTxtFldTxt() {
        return txtFld.getText();
    }

    public void setTxtFld(JTextField txtFld) {
        this.txtFld = txtFld;
    }

    public JButton getBtn() {
        return btn;
    }

    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    
    
    
    
}
