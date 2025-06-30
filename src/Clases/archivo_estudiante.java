package Clases;
import Excepciones.EstudanteDuplicado;
import Validacion.validar_datos;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner;


//import static proyecto.Proyecto.scanner;

public class archivo_estudiante {

    public void archivo_estudiante() {        
      try {
         //File myObj = new File("estudiante.txt");   
         File myObj = new File("C:\\Archivos\\estudiante.txt");   
                         
          validar_datos valida = new validar_datos();
          //System.out.print("Carnet del estudiante: ");
          //int carnet = scanner.nextInt();
          String carnet = valida.leerTexto("Carnet del estudiante: ");
          boolean existe = false;          
            // 1. Leer archivo línea por línea para buscar el carnet
            if (myObj.exists()) {
                Scanner lector = new Scanner(myObj);
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    if (linea.contains("Id: " + carnet)) {
                        existe = true;
                        break;
                    }
            }
                lector.close();
        }                  
            if (!existe) {//Sino existe el Id entonces agregarlo al archivo                 
                
                System.out.print("Agregando Estudiante\n");
                System.out.print("********************\n");               
                             
                String nombres = valida.leerTexto("Nombre del estudiante: ");
                String apellidos = valida.leerTexto("Apellido del estudiante: ");
                String email = valida.leerTexto("Email del estudiante: ");
                String telefono = valida.leerTexto("Telefono del estudiante: ");
                String carrera = valida.leerTexto("Carrera del estudiante: ");
                int nivel = valida.leerEntero("Nivel del estudiante: ");
                               
               // 2. Escribir en el archivo
               
               Estudiante registraestudiante = new Estudiante(carnet,carrera,nivel,nombres,apellidos,email,telefono);                      
            } else {   
                 throw new EstudanteDuplicado("El Estudiante con carnet: "+ carnet + " ya existe!"); 
            }
     } catch (IOException e) {
         //throw new EstudanteDuplicado("Estudiante sin Registrat");
               System.out.println("Error IOException.");
               e.printStackTrace();              
        }
        catch (EstudanteDuplicado ex) {
               System.out.println(ex.getMessage());                        
         }   
    }  
   
   
}
