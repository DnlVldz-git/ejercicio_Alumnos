/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicioAlumnos;

import ejercicioAlumnos.Excepciones.CalificacionException;
import java.io.Serializable;

/**
 *
 * @author dani
 */
public class Alumno implements Serializable{

    private String id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private double promedio;
    private Carrera carrera;

    public Alumno(String id, String nombre, String apellidoPaterno, String apellidoMaterno, double promedio, Carrera carrera) throws CalificacionException {
        try {
            setId(id);
            setNombre(nombre);
            setApellidoPaterno(apellidoPaterno);
            setApellidoMaterno(apellidoMaterno);
            setPromedio(promedio);
            setCarrera(carrera);
        } catch (CalificacionException ex) {
            throw new CalificacionException("Introduzca datos correctos");
        }catch(NumberFormatException ex2){
            throw new CalificacionException("Introduzca datos correctos");
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws CalificacionException {
        if (nombre.equals("")) {
            throw new CalificacionException("Introduzca un nombre válido");
        } else {
            this.nombre = nombre;

        }
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) throws CalificacionException {
        if (apellidoPaterno.equals("")) {
            throw new CalificacionException("Introduzca un apellido válido");
        } else {
            this.apellidoPaterno = apellidoPaterno;
        }
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) throws CalificacionException {
        if (apellidoMaterno.equals("")) {
            throw new CalificacionException("Introduzca un apellido válido");
        } else {
            this.apellidoMaterno = apellidoMaterno;
        }

    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) throws CalificacionException {
        if ((promedio > 0) && (promedio <= 10)) {
            this.promedio = promedio;
        } else {
            throw new CalificacionException("El promedio debe ser un número entre 0 y 10");
        }
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) throws CalificacionException {
        if (carrera == null) {
            throw new CalificacionException("Carrera inválida");
        } else {
            this.carrera = carrera;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Alumno) {
            Alumno alumno = (Alumno) obj;

            if (this.id.compareTo(alumno.getId()) == 0) {
                return true;
            }
        }
        return false;
    }

}
