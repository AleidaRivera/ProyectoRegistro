package Validacion;

import java.io.File;
import java.io.IOException;



public class validar_datos {
   
    
    // Rutas por defecto
    private static final String[] archivosRequeridos = {
        "estudiantes.txt",
        "profesores.txt",
        "cursos.txt",
        "matriculas.txt"
    };

    // Método para crear los archivos si no existen
    public static void verificarYCrearArchivos() {
        for (String nombreArchivo : archivosRequeridos) {
            File archivo = new File(nombreArchivo);
            if (!archivo.exists()) {
                try {
                    boolean creado = archivo.createNewFile();
                    if (creado) {
                        System.out.println("Archivo creado: " + nombreArchivo);
                    } else {
                        System.out.println("No se pudo crear el archivo: " + nombreArchivo);
                    }
                } catch (IOException e) {
                    System.out.println("Error al crear el archivo: " + nombreArchivo);
                }
            } else {
                System.out.println("Archivo ya existe: " + nombreArchivo);
            }
        }
    }
}
