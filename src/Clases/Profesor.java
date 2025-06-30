package Clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author RODRIGUEZ
 */
public class Profesor extends Persona {
     
    private String idProfesor;
    private String especialidad;
    private String tipoContrato;

    public Profesor(String idProfesor, String especialidad, String tipoContrato, String nombres, String apellidos, String email, String telefono) {
        super(nombres, apellidos, email, telefono);
        this.idProfesor = idProfesor;
        this.especialidad = especialidad;
        this.tipoContrato = tipoContrato;
        
        
         //System.out.print("entro aca!\n");
         File myObj = new File("C:\\Archivos\\profesor.txt");                                         
                     
        try {
            FileWriter escritor = new FileWriter(myObj, true); // true para agregar (append)  
            escritor.write("Id: " + idProfesor + " | ");
            escritor.write(nombres + " | "); 
            escritor.write(apellidos + " | ");
            escritor.write(email + " | ");
            escritor.write(telefono + " | ");
            escritor.write(especialidad + " | ");
            escritor.write(tipoContrato + " |\n");
            System.out.print("Profesor Agregado al Sistema!\n");
            escritor.close();       
        } catch (IOException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }  
        
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
