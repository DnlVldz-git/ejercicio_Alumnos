/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos.gui;

import ejercicioAlumnos.AcercaDeDialog;
import ejercicioAlumnos.Alumno;
import ejercicioAlumnos.AlumnosTableModel;
import ejercicioAlumnos.Carrera;
import ejercicioAlumnos.Controller;
import ejercicioAlumnos.Excepciones.AlumnoExistenteException;
import ejercicioAlumnos.Excepciones.CalificacionException;
import ejercicioAlumnos.MenuActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

/**
 *
 * @author dani
 */
public class PrincipalFrame extends JFrame {

    private BusquedaPanel searchPnl;
    private Controller control;
    private JTable table;
    private Menu menu;
    private AlumnosDialog alumDia;
    private AcercaDeDialog acercaDialog;
    private AlumnosTableModel tblMdl;
    private BorrarDialog borrarDialog;

    public PrincipalFrame() throws CalificacionException, AlumnoExistenteException, ClassNotFoundException {
        super("Control Alumnos");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(600, 200);
        super.setLocationRelativeTo(null);

        this.control = new Controller();  
        
        this.acercaDialog = new AcercaDeDialog();
        
        this.tblMdl = new AlumnosTableModel(control);

        this.table = new JTable(tblMdl);

        this.searchPnl = new BusquedaPanel();

        this.menu = new Menu();

        this.alumDia = new AlumnosDialog(this);   
        
        this.borrarDialog = new BorrarDialog(this);

        MenuActionListener e = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alumDia.setVisible(true);
                if (alumDia.isFlag()) {
                    try {
                        if (alumDia.getAlumno() == null) {
                            
                        }else{
                            control.add(alumDia.getAlumno()); 
                            tblMdl.fireTableDataChanged();                            
                        }                        

                    } catch (AlumnoExistenteException ex) {
                        actionPerformed(e);                    
                    }                    
                } else {
                    
                }
            }
        };
        
        MenuActionListener e2 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.guardar();                
            }
        };
        
        MenuActionListener e3 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(null, "Salir", "¿Desea salir?", JOptionPane.CANCEL_OPTION);
                if (res == 0) {
                    System.exit(1);
                }else{
                    
                }
            }
        };
        
        MenuActionListener e4 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                acercaDialog.setVisible(true);
            }
        };
            
        MenuActionListener e5 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (searchPnl.getTxtFldTxt().equals("")) {
                    
                }else{
                    System.out.println(searchPnl.getTxtFldTxt());
                    JOptionPane.showMessageDialog(null, control.search(searchPnl.getTxtFldTxt())); 
                }
            }
        };
        
        MenuActionListener e6 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (borrarDialog.getTxtFldTxt().equals("")) {
                    JOptionPane.showMessageDialog(null, "No introdujo un alumno");
                }else if (control.borrar(borrarDialog.getTxtFldTxt())==0) {
                    JOptionPane.showMessageDialog(null, "Se ha borrado el alumno");
                }else{
                    JOptionPane.showMessageDialog(null, "El alumno no existe");
                }
                borrarDialog.cleanTxtFld();
            }
        };
        
        MenuActionListener e7 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarDialog.setVisible(false);
            }
        };
        
        MenuActionListener e8 = new MenuActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarDialog.setVisible(true);
            }
        };
        
        this.menu.getNuevo().addActionListener(e);
        this.menu.getGuardar().addActionListener(e2);
        this.menu.getSalir().addActionListener(e3);
        this.menu.getAcercaDe().addActionListener(e4);
        this.searchPnl.getBtn().addActionListener(e5);
        this.menu.getBorrar().addActionListener(e8);
        this.borrarDialog.getBtnCancelar().addActionListener(e7);
        this.borrarDialog.getBtnBorrar().addActionListener(e6);
        
        super.add(new JScrollPane(this.table), BorderLayout.CENTER);
        super.add(menu, BorderLayout.NORTH);
        super.add(this.searchPnl, BorderLayout.SOUTH);
        super.setVisible(true);
        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PrincipalFrame();
                } catch (CalificacionException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (AlumnoExistenteException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PrincipalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
