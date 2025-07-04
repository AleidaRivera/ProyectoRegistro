package Clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Profesor extends Persona {
     
    private String idProfesor;
    private String especialidad;
    private String tipoContrato;

    public Profesor(String idProfesor, String especialidad, String tipoContrato, String nombres, String apellidos, String email, String telefono) {
        super(nombres, apellidos, email, telefono);
        this.idProfesor = idProfesor;
        this.especialidad = especialidad;
        this.tipoContrato = tipoContrato;
        
    }

    public String getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

         
     @Override
    public String toString() {
        return "Profesor: " + getNombreCompleto() + " - " + especialidad;
    }
}
