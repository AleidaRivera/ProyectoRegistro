package Validacion;

import java.util.Scanner;

public class validar_datos {
    
    static Scanner scanner = new Scanner(System.in);
    
     // Métodos auxiliares de validación
    public int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine();
            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Debe ingresar un numero entero valido.");
            }
        }
    }
    
     public  String leerTexto(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = scanner.nextLine();
            if (!texto.trim().isEmpty()) {
                return texto;
            } else {
                System.out.println("⚠ Este campo no puede estar vacio.");
            }
        }
    }
}
