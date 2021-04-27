/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.gui;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dani
 */
public class BorrarDialog extends JDialog{
    private JPanel pnl;
    private JButton btnBorrar;
    private JButton btnCancelar;
    private JTextField txtFld;
    private JLabel lbl;
    
    public BorrarDialog(JFrame parent){
        super(parent, true);
        super.setSize(275, 380);
        
        this.pnl = new JPanel();
        this.btnBorrar = new JButton("Borrar");
        this.btnCancelar = new JButton("Cancelar");
        this.txtFld = new JTextField(10);
        this.lbl = new JLabel("Introduzca el id");
        
        this.pnl.add(this.lbl);
        this.pnl.add(this.txtFld);
        this.pnl.add(this.btnBorrar);
        this.pnl.add(this.btnCancelar);
        
        super.add(pnl);
        
    }

    public JButton getBtnBorrar() {
        return btnBorrar;
    }
    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public String getTxtFldTxt() {
        return txtFld.getText();
    }
   
    public void cleanTxtFld(){
        this.txtFld.setText("");
    }
    
}


