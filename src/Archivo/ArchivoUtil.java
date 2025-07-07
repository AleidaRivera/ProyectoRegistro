
package Archivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class ArchivoUtil {
     public static void guardarEnArchivo(String ruta, List<String> lineas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta, true))) {
            for (String linea : lineas) {
                writer.write(linea);
                writer.newLine();
            }
            writer.write("-----------------------------");
            writer.newLine();
        } catch (IOException ex) {
            System.err.println("Error al guardar en archivo: " + ex.getMessage());
        }
     }
     public static void mostrarArchivo(String ruta) {
    try (Scanner lector = new Scanner(new java.io.File(ruta))) {
        while (lector.hasNextLine()) {
            System.out.println(lector.nextLine());
        }
    } catch (IOException e) {
        System.err.println("Error al leer el archivo: " + e.getMessage());
    }
  }
}
