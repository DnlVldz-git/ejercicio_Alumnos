/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author dani
 */
public class AlumnosTableModel extends AbstractTableModel{
    private Controller control;
    
    public AlumnosTableModel(Controller control){
        this.control = control;        
    }

    @Override
    public int getRowCount() {
        return control.getNumAlumnos();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumno alumno = control.getAlumno(rowIndex);
        switch (columnIndex) {
            case 0:
                return alumno.getId();
            case 1:
                return alumno.getNombre();
            case 2:
                return alumno.getApellidoPaterno();
            case 3:
                return alumno.getApellidoMaterno();
            case 4:
                return alumno.getPromedio();
            case 5:
                return alumno.getCarrera();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Id";
            case 1:
                return "Nombre";
            case 2:
                return "Apellido Paterno";
            case 3:
                return "Apellido Materno";
            case 4:
                return "Promedio";
            case 5:
                return "Carrera";
            default:
                throw new AssertionError();
        }
    }
    
    
    
}
