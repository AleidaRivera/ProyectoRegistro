
package Clases;
import Excepciones.CursoSinRegistrar;
import java.lang.System.Logger.Level;

import java.util.Scanner;
public class Principal {

     static Scanner scanner = new Scanner(System.in);
     public static void main(String[] args) {
        int opcion;                   
             
        do {
            System.out.println("\n--- REGISTRO UNIVERSIDAD UISIL ---");
            System.out.println("\n*********************************");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Ingresar profesor");
            System.out.println("3. Ingresar curso");
            System.out.println("4. Registrar matricula");
            System.out.println("5. Mostrar registros");
            System.out.println("0. Salir");
            System.out.println("***********************************");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // limpiar buffer

            switch (opcion) {
                case 1 -> ingresarEstudiante();  
                case 2 -> ingresarProfesor();
                case 3 -> ingresarCurso();
                case 4 -> registrarMatricula();
                case 5 -> mostrarRegistros();
                case 0 -> System.out.println("Saliendo del Sistema.");
                default -> System.out.println("Opcion invalida, escoja una opcion valida");
            }
        } while (opcion != 0);
    }

    static void ingresarEstudiante() {   
        
        archivo_estudiante archivo_estudiante = new archivo_estudiante();        
        archivo_estudiante.archivo_estudiante();
    }

    static void ingresarProfesor() {
        //System.out.println("3. Ingresa aca profesor");
      archivo_profesor archivo_profesor = new archivo_profesor();        
      archivo_profesor.archivo_profesor();
    }

    static void ingresarCurso() {
        
      archivo_cursos archivo_cursos = new archivo_cursos();        
       try {
           archivo_cursos.archivo_cursos();
       } catch (CursoSinRegistrar ex) {
          // Logger.getLogger(proyecto.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    static void registrarMatricula() {
      
    }

    static void mostrarRegistros() {
     
        
    }
    
    
     //El programa crea los acrhivos en C:\Archivos, por lo que la carpeta debe existir antes
     //de correr el sistema. El programa valida que el archivo exista, si no existe lo crea
     //asi como valida que los id ingresados existan o no.
    
    
 }
    
