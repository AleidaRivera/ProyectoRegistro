package Clases;
import Excepciones.ProfesorDuplicado;
import Validacion.validar_datos;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
//import java.io.FileWriter;
import java.util.Scanner;



public class archivo_profesor {
    
    public void archivo_profesor() {        
      try {
         //File myObj = new File("profesor.txt");   
         File myObj = new File("C:\\Archivos\\profesor.txt");   
         validar_datos valida = new validar_datos();                
          boolean existe = false;         
         String idProfesor = valida.leerTexto("ID del Profesor: ");
          //int id = scanner.nextInt();

            // 1. Leer archivo línea por línea para buscar el carnet
            if (myObj.exists()) {
                Scanner lector = new Scanner(myObj);
                while (lector.hasNextLine()) {
                    String linea = lector.nextLine();
                    if (linea.contains("Id: " + idProfesor)) {
                        existe = true;
                        break;
                    }
            }
                lector.close();
        }                  
            if (!existe) {//Sino existe el Id entonces agregarlo al archivo                 
                
                System.out.print("Agregando Profesor\n");
                System.out.print("********************\n");   
                             
                String nombres = valida.leerTexto("Nombre del Profesor: ");
                String apellidos = valida.leerTexto("Apellido del Profesor: ");
                String email = valida.leerTexto("Email del Profesor: ");
                String telefono = valida.leerTexto("Telefono del Profesor: ");
                String especialidad = valida.leerTexto("Especialidad del Profesor: ");
                String tipoContrato = valida.leerTexto("Tipo de Contrato (Tiempo Completo/Por Horas): ");
                
                
               // 2. Escribir en el archivo
               //profesor registra = new profesor();
                // 2. Escribir en el archivo
               Profesor registraprofesor = new Profesor(idProfesor,especialidad,tipoContrato,nombres,apellidos,email,telefono);
               
               //Profesor registraprofesor = new profesor(id,nombre,apellido,email,telefono,especialidad,contrato);                      
            } else {                 
                 throw new ProfesorDuplicado("El Profesor con Id: "+ idProfesor + " ya existe!"); 
            }
     } catch (IOException e) {
               System.out.println("Error IOException.");
                e.printStackTrace();
         }   
       catch (ProfesorDuplicado ex) {
               System.out.println(ex.getMessage());                        
         }   
      
   }      
}

