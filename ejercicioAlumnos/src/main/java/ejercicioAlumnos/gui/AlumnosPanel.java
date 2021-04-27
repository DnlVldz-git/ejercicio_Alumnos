/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.gui;

import ejercicioAlumnos.Excepciones.CalificacionException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author dani
 */
public class AlumnosPanel extends JPanel{
    private JLabel lblId;
    private JLabel lblNombre;
    private JLabel lblApellidoP;
    private JLabel lblApellidoM;
    private JLabel lblPromedio;
    private JLabel lblCarrera;
    private JTextField txtFldId;
    private JTextField txtFldNombre;
    private JTextField txtFldApellidoP;
    private JTextField txtFldApellidoM;
    private JTextField txtFldPromedio;
    private JRadioButton sistemas;
    private JRadioButton com;
    private JRadioButton medicina;
    private JRadioButton industrial;
    private ButtonGroup buttonGroup;
    private JButton submit;
    private JButton cancel;
    
    public AlumnosPanel(){
        lblId = new JLabel("Id:");
        lblNombre = new JLabel("Nombre:");
        lblApellidoP = new JLabel("Apellido Paterno:");
        lblApellidoM = new JLabel("Apellido Materno:");
        lblPromedio = new JLabel("Promedio:");
        lblCarrera = new JLabel("Carrera:");
        
        txtFldId = new JTextField(20);
        txtFldNombre = new JTextField(20);
        txtFldApellidoP = new JTextField(20);
        txtFldApellidoM = new JTextField(20);
        txtFldPromedio = new JTextField(20);
        
        sistemas = new JRadioButton("Sistemas");
        com = new JRadioButton("Comunicacion");
        medicina = new JRadioButton("Medicina");
        industrial = new JRadioButton("Industrial");
        
        this.buttonGroup = new ButtonGroup();
        
        this.buttonGroup.add(sistemas);
        this.buttonGroup.add(com);
        this.buttonGroup.add(medicina);
        this.buttonGroup.add(industrial);
        
        submit = new JButton("Guardar");
        cancel = new JButton("Cancelar");
        
        add(lblId);
        add(txtFldId);
        add(lblNombre);
        add(txtFldNombre);
        add(lblApellidoP);
        add(txtFldApellidoP);
        add(lblApellidoM);
        add(txtFldApellidoM);
        add(lblPromedio);
        add(txtFldPromedio);
        add(lblCarrera);        
        add(sistemas);
        add(com);
        add(medicina);
        add(industrial);
        add(submit);
        add(cancel);
    }

    public String getTxtFldId() {
        return txtFldId.getText();
    }

    public String getTxtFldNombre() {
        return txtFldNombre.getText();
    }

    public String getTxtFldApellidoP() {
        return txtFldApellidoP.getText();
    }

    public String getTxtFldApellidoM() {
        return txtFldApellidoM.getText();
    }

    public Double getTxtFldPromedio() throws Exception{     
        try {
            return Double.valueOf(txtFldPromedio.getText());
        } catch (Exception e) {
            throw new CalificacionException("Calificación incorrecta");
        }
        
    }

    public JRadioButton getSistemas() {
        return sistemas;
    }

    public JRadioButton getCom() {
        return com;
    }

    public JRadioButton getMedicina() {
        return medicina;
    }

    public JRadioButton getIndustrial() {
        return industrial;
    }

    public JButton getSubmit() {
        return submit;
    }

    public JButton getCancel() {
        return cancel;
    }

    public void setCancel(JButton cancel) {
        this.cancel = cancel;
    }
    
    public void clean(){
        this.txtFldId.setText(null);
        this.txtFldNombre.setText(null);
        this.txtFldApellidoP.setText(null);
        this.txtFldApellidoM.setText(null);        
        this.txtFldPromedio.setText(null);                
    }
    
}
