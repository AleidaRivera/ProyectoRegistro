/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author RODRIGUEZ
 */
public class Profesor extends Persona {
     
    private String idProfesor;
    private String especialidad;
    private Persona.TipoContrato tipoContrato;

    public Profesor(String idProfesor, String especialidad, Persona.TipoContrato tipoContrato, String nombres, String apellidos, String email, String telefono) {
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

    public Persona.TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(Persona.TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }
    
     @Override
    public String toString() {
        return "Profesor: " + getNombreCompleto() + " - " + especialidad;
    }
}
