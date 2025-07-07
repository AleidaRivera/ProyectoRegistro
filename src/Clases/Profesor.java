package Clases;

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

    public String getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(String tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idProfesor=" + idProfesor + ", especialidad=" + especialidad + ", tipoContrato=" + tipoContrato + '}';
    }

  
}
