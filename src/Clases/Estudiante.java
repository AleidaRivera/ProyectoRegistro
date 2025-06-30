
package Clases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Estudiante extends Persona {
    private String carnet;
    private String carrera;
    private int nivel;

    public Estudiante(String carnet, String carrera, int nivel, String nombres, String apellidos, String email, String telefono) {
        super(nombres, apellidos, email, telefono);
        this.carnet = carnet;
        this.carrera = carrera;
        this.nivel = nivel;
        
          //System.out.print("entro aca!\n");
         File myObj = new File("C:\\Archivos\\estudiante.txt");                                         
                     
        try {
            FileWriter escritor = new FileWriter(myObj, true); // true para agregar (append)  
            escritor.write("Id: " + carnet + " | ");
            escritor.write(nombres + " | "); 
            escritor.write(apellidos + " | ");
            escritor.write(email + " | ");
            escritor.write(telefono + " | ");
            escritor.write(carrera + " | ");
            escritor.write(nivel + " |\n");
            System.out.print("Estudiante Agregado al Sistema!\n");
            escritor.close();       
        } catch (IOException ex) {
            System.out.println(ex.getMessage());  
        } 
      
        
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    

    
    @Override
    public String toString() {
        return "Estudiante: " + getNombreCompleto() + " - " + carrera + " (Nivel " + nivel + ")";
    }
    
}
