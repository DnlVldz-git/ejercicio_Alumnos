/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos;

import ejercicioAlumnos.Excepciones.AlumnoExistenteException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author dani
 */
public class Controller {

    private ArrayList<Alumno> alumnos;

    public Controller() throws ClassNotFoundException {
        this.alumnos = new ArrayList();
        this.cargar();
    }

    public boolean add(Alumno a) throws AlumnoExistenteException {
        if (this.alumnos.contains(a)) {
            throw new AlumnoExistenteException("Este alumno ya existe");
        } else {
            return alumnos.add(a);
        }
    }

    public Alumno getAlumno(int index) {
        return alumnos.get(index);
    }

    public Integer getNumAlumnos() {
        return alumnos.size();
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public String search(String id) {
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                return "El alumno con el id: "+alumno.getId()
                        + "\nNombre: " + alumno.getNombre()
                        + "\nApellidos: " + alumno.getApellidoPaterno()
                        + "\n" + alumno.getApellidoMaterno()
                        + "\nPromedio: " + alumno.getPromedio()
                        + "\nCarrera: " + alumno.getCarrera();
            }
        }
        return "No existe registro del alumno";
    }

    public void guardar() {
        try {
            File file = new File("datos.dat");
            FileOutputStream output = new FileOutputStream(file);
            ObjectOutputStream writer = new ObjectOutputStream(output);

            writer.writeObject(this.alumnos);

            writer.close();
            output.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar");
        }
    }
    
    public int borrar(String id){
        for (Alumno alumno : alumnos) {
            if (alumno.getId().equals(id)) {
                alumnos.remove(alumno);
                return 0;
            }
        }
        return -1;
    }

    public void cargar() throws ClassNotFoundException {
        File file = new File("datos.dat");
        if (file.exists()) {
            try {
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream reader = new ObjectInputStream(input);

                this.alumnos = (ArrayList<Alumno>) reader.readObject();

                input.close();
                reader.close();

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cargar");
            }
        } else {
            this.alumnos = new ArrayList();
        }

    }

}
