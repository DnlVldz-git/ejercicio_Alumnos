/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.gui;

import ejercicioAlumnos.Alumno;
import ejercicioAlumnos.Carrera;
import ejercicioAlumnos.Excepciones.CalificacionException;
import ejercicioAlumnos.MenuActionListener;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author dani
 */
public class AlumnosDialog extends JDialog {

    private AlumnosPanel pnl;
    private Alumno alumno;
    private boolean flag;

    public AlumnosDialog(JFrame parent) {
        super(parent, true);
        super.setSize(275, 380);

        flag = false;
        
        pnl = new AlumnosPanel();

        MenuActionListener e = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = true;
                if (pnl.getSistemas().isSelected()) {
                    try {
                        alumno = new Alumno(pnl.getTxtFldId(), pnl.getTxtFldNombre(), pnl.getTxtFldApellidoP(), pnl.getTxtFldApellidoM(), pnl.getTxtFldPromedio(), Carrera.SISTEMAS);
                        setVisible(false);
                    } catch (CalificacionException ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (pnl.getCom().isSelected()) {
                    try {
                        alumno = new Alumno(pnl.getTxtFldId(), pnl.getTxtFldNombre(), pnl.getTxtFldApellidoP(), pnl.getTxtFldApellidoM(), pnl.getTxtFldPromedio(), Carrera.COMUNICACION);
                        setVisible(false);
                    } catch (CalificacionException ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (pnl.getMedicina().isSelected()) {
                    try {
                        alumno = new Alumno(pnl.getTxtFldId(), pnl.getTxtFldNombre(), pnl.getTxtFldApellidoP(), pnl.getTxtFldApellidoM(), pnl.getTxtFldPromedio(), Carrera.MEDICINA);
                        setVisible(false);
                    } catch (CalificacionException ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        alumno = new Alumno(pnl.getTxtFldId(), pnl.getTxtFldNombre(), pnl.getTxtFldApellidoP(), pnl.getTxtFldApellidoM(), pnl.getTxtFldPromedio(), Carrera.INDUSTRIAL);
                        setVisible(false);

                    } catch (CalificacionException ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(AlumnosDialog.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                pnl.clean();

            }
        };

        MenuActionListener e2 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag = false;
                setVisible(false);
            }
        };
        pnl.getSubmit().addActionListener(e);
        pnl.getCancel().addActionListener(e2);

        super.add(pnl);
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public boolean isFlag() {
        return flag;
    }
         
}
