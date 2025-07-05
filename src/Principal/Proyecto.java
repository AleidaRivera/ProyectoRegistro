
package Principal;

import Clases.Cursos;
import Clases.Estudiante;
import Clases.GestionAcademica;
import Clases.Matricula;
import Clases.Profesor;
import Interfaz.Procesable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;


public class Proyecto {


    public static void main(String[] args) throws IOException {
        File  archivo;
        try{
            archivo = new File("C:\\archivos\\archivos.txt");
            
            if(archivo.createNewFile()){
                System.out.println();
            }
        } catch (IOException e){
            System.err.println();
        }
        
        Scanner scanner = new Scanner(System.in);
        Procesable sistema = new GestionAcademica();
      
        int opcion;
        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Profesor");
            System.out.println("3. Crear Curso");
            System.out.println("4. Matricular Estudiante");
            System.out.println("5. Ver estudiantes");
            System.out.println("6. Ver profesores");
            System.out.println("7. Ver cursos");
            System.out.println("8. Ver matrículas");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.println("== REGISTRO DE ESTUDIANTE ==");
                    System.out.print("Carnet: ");
                    String carnet = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Carrera: ");
                    String carrera = scanner.nextLine();
                    System.out.print("Nivel: ");
                    String nivel = scanner.nextLine();

                try {
                Estudiante estudiante = new Estudiante(carnet, nivel, carrera , nombre, apellido, email,telefono);
                if (sistema.registrarEstudiante(estudiante)) {
                System.out.println("Estudiante registrado correctamente.");
                } else {
                System.out.println("Error al registrar estudiante.");
                }
                } catch (Exception e) {
                System.err.println("Se produjo un error al registrar el estudiante: " + e.getMessage());
                e.printStackTrace();
}

                case 2:
                    System.out.println("== REGISTRO DE PROFESOR ==");
                    System.out.print("ID Profesor: ");
                    String idProfesor = scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombreProf = scanner.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoProf = scanner.nextLine();
                    System.out.print("Email: ");
                    String emailProf = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefonoProf = scanner.nextLine();
                    System.out.print("Especialidad: ");
                    String especialidad = scanner.nextLine();
                    System.out.print("Tipo de Contrato: ");
                    String contrato = scanner.nextLine();

                    Profesor profesor = new Profesor(idProfesor, nombreProf, apellidoProf, emailProf, telefonoProf, especialidad, contrato);
                    if (sistema.registrarProfesor(profesor)) {
                        System.out.println("Profesor registrado correctamente.");
                    } else {
                        System.out.println("Error al registrar profesor.");
                    }
                    break;

                case 3:
                    System.out.println("== CREAR CURSO ==");
                    System.out.print("Código del curso (número): ");
                    int codigoCurso = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nombre del curso: ");
                    String nombreCurso = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("ID del profesor asignado (debe existir): ");
                    int idProfesorCurso = Integer.parseInt(scanner.nextLine());
                    System.out.print("Capacidad máxima: ");
                    int capacidad = Integer.parseInt(scanner.nextLine());

                    Cursos curso = new Cursos(codigoCurso, nombreCurso, descripcion, idProfesorCurso, capacidad);
                    if (sistema.crearCurso(curso)) {
                        System.out.println("Curso creado correctamente.");
                    } else {
                        System.out.println("Error al crear curso.");
                    }
                    break;

                case 4:
                    System.out.println("== MATRICULAR ESTUDIANTE ==");
                    System.out.print("Carnet del estudiante: ");
                    String carnetEstudiante = scanner.nextLine();
                    System.out.print("Código del curso: ");
                    String codCurso = scanner.nextLine();

                    if (sistema.matricularEstudiante(carnetEstudiante, codCurso)) {
                        System.out.println("Estudiante matriculado correctamente.");
                    } else {
                        System.out.println("Error al matricular estudiante.");
                    }
                    break;

                case 5:
                    System.out.println("== LISTA DE ESTUDIANTES ==");
                    List<Estudiante> listaEstudiantes = sistema.obtenerTodosLosEstudiantes();
                    for (Estudiante e : listaEstudiantes) {
                        System.out.println(e);
                    }
                    break;

                case 6:
                    System.out.println("== LISTA DE PROFESORES ==");
                    List<Profesor> listaProfesores = sistema.obtenerTodosLosProfesores();
                    for (Profesor p : listaProfesores) {
                        System.out.println(p);
                    }
                    break;

                case 7:
                    System.out.println("== LISTA DE CURSOS ==");
                    List<Cursos> listaCursos = sistema.obtenerTodosLosCursos();
                    for (Cursos c : listaCursos) {
                        System.out.println(c);
                    }
                    break;

                case 8:
                    System.out.println("== LISTA DE MATRÍCULAS ==");
                    List<Matricula> listaMatriculas = sistema.obtenerTodasLasMatriculas();
                    for (Matricula m : listaMatriculas) {
                        System.out.println(m);
                    }
                    break;

                case 9:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 9);

        scanner.close();
    }
}
    
