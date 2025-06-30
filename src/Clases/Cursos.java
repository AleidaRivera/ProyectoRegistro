
package Clases;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cursos {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int profesor;
    private int capacidadMaxima;
   
    public Cursos (int codigo, String nombre, String descripcion, int profesor, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.capacidadMaxima = capacidadMaxima;
             
               
        File myObj = new File("C:\\Archivos\\cursos.txt");                                         
                     
        try {
            FileWriter escritor = new FileWriter(myObj, true); // true para agregar (append)  
            escritor.write("Id: " + codigo + " | ");
            escritor.write(nombre + " | "); 
            escritor.write(descripcion + " | "); 
            escritor.write(profesor + " | ");
            escritor.write(capacidadMaxima + " | ");               
            System.out.print("Curso Agregado al Sistema!\n");
            escritor.close();       
        } catch (IOException ex) {
            Logger.getLogger(Estudiante.class.getName()).log(Level.SEVERE, null, ex);
        }               
        
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
   
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }     
 }
   

