
package Principal;

import Archivo.ArchivoUtil;
import Clases.Cursos;
import Clases.Estudiante;
import Clases.GestionAcademica;
import Clases.Profesor;
import Interface.Procesable;
import java.util.List;
import java.util.Scanner;

public class Inicio {

    public static void main(String[] args) {
        
    
     Scanner scanner = new Scanner(System.in);
        Procesable sistema = new GestionAcademica();
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar Estudiantes");
            System.out.println("2. Registrar Profesores");
            System.out.println("3. Crear Curso");
            System.out.println("4. Matricular Estudiante");
            System.out.println("5. Ver Estudiantes");
            System.out.println("6. Ver Profesoress");
            System.out.println("7. Ver Cursos");
            System.out.println("8. Ver Matriculas");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1 -> {
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

                    Estudiante estudiante = new Estudiante(carnet, nivel, carrera, nombre, apellido, email, telefono);
                    if (sistema.registrarEstudiante(estudiante)) {
                        System.out.println("Estudiante registrado correctamente.");
                        ArchivoUtil.guardarEnArchivo("C:\\archivos\\estudiantes.txt", List.of(
                                "Carnet: " + carnet,
                                "Nombre: " + nombre,
                                "Apellido: " + apellido,
                                "Email: " + email,
                                "Teléfono: " + telefono,
                                "Carrera: " + carrera,
                                "Nivel: " + nivel
                        ));
                    }
               }

                case 2 -> {
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
                    System.out.print("Contrato: ");
                    String contrato = scanner.nextLine();

                    Profesor profesor = new Profesor(idProfesor, nombreProf, apellidoProf, emailProf, telefonoProf, especialidad, contrato);
                    if (sistema.registrarProfesor(profesor)) {
                        System.out.println("Profesor registrado correctamente.");
                        ArchivoUtil.guardarEnArchivo("C:\\archivos\\profesor.txt", List.of(
                                "ID Profesor: " + idProfesor,
                                "Nombre: " + nombreProf,
                                "Apellido: " + apellidoProf,
                                "Email: " + emailProf,
                                "Teléfono: " + telefonoProf,
                                "Especialidad: " + especialidad,
                                "Contrato: " + contrato
                        ));
                    }
               }

                case 3 -> {
                    System.out.println("== CREAR CURSO ==");
                    System.out.print("Código del curso: ");
                    int codigoCurso = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nombre del curso: ");
                    String nombreCurso = scanner.nextLine();
                    System.out.print("Descripción: ");
                    String descripcion = scanner.nextLine();
                    System.out.print("ID del profesor asignado: ");
                    int idProfCurso = Integer.parseInt(scanner.nextLine());
                    System.out.print("Capacidad máxima: ");
                    int capacidad = Integer.parseInt(scanner.nextLine());

                    Cursos curso = new Cursos(codigoCurso, nombreCurso, descripcion, idProfCurso, capacidad);
                    if (sistema.crearCurso(curso)) {
                        System.out.println("Curso creado correctamente.");
                        ArchivoUtil.guardarEnArchivo("C:\\archivos\\cursos.txt", List.of(
                                "Código: " + codigoCurso,
                                "Nombre: " + nombreCurso,
                                "Descripción: " + descripcion,
                                "Profesor Asignado: " + idProfCurso,
                                "Capacidad: " + capacidad
                        ));
                    }
               }

                case 4 -> {
                    System.out.println("== MATRICULAR ESTUDIANTE ==");
                    System.out.print("Carnet del estudiante: ");
                    String carnetEst = scanner.nextLine();
                    System.out.print("Código del curso: ");
                    String codCurso = scanner.nextLine();

                    if (sistema.matricularEstudiante(carnetEst, codCurso)) {
                        System.out.println("Estudiante matriculado correctamente.");
                        ArchivoUtil.guardarEnArchivo("C:\\archivos\\matriculas.txt", List.of(
                                "Carnet Estudiante: " + carnetEst,
                                "Código del Curso: " + codCurso
                        ));
                    }
               }

                case 5 -> {
                    System.out.println("== ESTUDIANTES REGISTRADOS ==");
                    sistema.obtenerTodosLosEstudiantes().forEach(System.out::println);
               }

                case 6 -> {
                    System.out.println("== PROFESORES REGISTRADOS ==");
                    sistema.obtenerTodosLosProfesores().forEach(System.out::println);
               }

                case 7 -> {
                    System.out.println("== CURSOS CREADOS ==");
                    sistema.obtenerTodosLosCursos().forEach(System.out::println);
               }

                case 8 -> {
                    System.out.println("== MATRÍCULAS REGISTRADAS ==");
                    sistema.obtenerTodasLasMatriculas().forEach(System.out::println);
               }

                case 9 -> {
                    System.out.println("== CONTENIDO DE estudiantes.txt ==");
                    ArchivoUtil.mostrarArchivo("C:\\archivos\\estudiantes.txt");
               }

                case 10 -> {
                    System.out.println("== CONTENIDO DE profesor.txt ==");
                    ArchivoUtil.mostrarArchivo("C:\\archivos\\profesor.txt");
               }

                case 11 -> {
                    System.out.println("== CONTENIDO DE cursos.txt ==");
                    ArchivoUtil.mostrarArchivo("C:\\archivos\\cursos.txt");
               }

                case 12 -> {
                    System.out.println("== CONTENIDO DE matriculas.txt ==");
                    ArchivoUtil.mostrarArchivo("C:\\archivos\\matriculas.txt");
               }
                    
                case 13 -> System.out.println("¡Hasta luego!");

                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 13);
    }
  }   
    

