package Clases;
import Excepciones.CursoSinRegistrar;
import Excepciones.ProfesorSinRegistrar;
import Validacion.validar_datos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class archivo_cursos {

    public void archivo_cursos() throws CursoSinRegistrar {
        
        validar_datos valida = new validar_datos(); 
        try {
            File archivoCurso = new File("C:\\Archivos\\cursos.txt");
            boolean cursoExiste = false;
                       
            int idCurso = valida.leerEntero("Id del Curso: ");

            if (archivoCurso.exists()) {
                Scanner lectorCurso = new Scanner(archivoCurso);
                while (lectorCurso.hasNextLine()) {
                    String linea = lectorCurso.nextLine();
                    if (linea.contains("Id: " + idCurso)) {
                        cursoExiste = true;
                        break;
                    }
                }
                lectorCurso.close();
            }

            if (!cursoExiste) {
                System.out.println("\nAgregando Curso");
                System.out.println("********************");

                int idProfesor = valida.leerEntero("Id del Profesor: ");
                
                File archivoProfesor = new File("C:\\Archivos\\profesor.txt");
                boolean profesorExiste = false;

                if (archivoProfesor.exists()) {
                    Scanner lectorProfesor = new Scanner(archivoProfesor);
                    while (lectorProfesor.hasNextLine()) {
                        String linea = lectorProfesor.nextLine();
                        if (linea.contains("Id: " + idProfesor)) {
                            profesorExiste = true;
                            break;
                        }
                    }
                    lectorProfesor.close();
                }

                if (!profesorExiste) {
                    throw new ProfesorSinRegistrar("El Profesor con Id: " + idProfesor + " no existe, agregar Profesor!");
                }

                // Ingresar información del curso               
                 
                String nombre = valida.leerTexto("Nombre del Curso: ");
                String descripcion = valida.leerTexto("Descripcion del Curso: ");
                int capacidadMaxima = valida.leerEntero("Capacidad del Curso: ");
               
                
               int codigo = idCurso;
               Cursos registracurso = new Cursos(codigo,nombre,descripcion,idProfesor,capacidadMaxima);                                 

            } else {
                throw new CursoSinRegistrar("El Curso con Id: " + idCurso + " ya existe!");
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida.");
            e.printStackTrace();
        } catch (ProfesorSinRegistrar ex) {
            System.out.println(ex.getMessage());
        } catch (CursoSinRegistrar ex2) {
            System.out.println(ex2.getMessage());
        }
    }
    
    
    public static List<String> leerArchivo(String ruta) {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            return lineas;
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }
    }
    
}   
        
    