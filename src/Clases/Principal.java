
package Clases;

import Clases.Persona.TipoContrato;
import Excepciones.CursoLleno;
import Excepciones.EstudanteDuplicado;
import java.util.ArrayList;
public class Principal {

   
    public static void main(String[] args) {
      
        Profesor profesor = new Profesor(
            "PROF001", "Ingeniería de Software", TipoContrato.TIEMPO_COMPLETO,
            "Luis", "Vargas Gomez", "lvargasGomez@UISIL.com", "2234-5678"
        );

        Cursos curso = new Cursos(
            "ISB-21", "Programación Orientada a Objetos",
            "Curso básico de programación en Java", profesor, 30,
            new ArrayList<>()
        );

        Estudiante estudiante1 = new Estudiante(
            "2024001", "Ingeniería en Sistemas", 1,
            "María", "González Pérez", "mgonzalez@estudiante.com", "8765-4321"
        );

        Estudiante estudiante2 = new Estudiante(
            "2024001", "Ingeniería en Sistemas", 1,
            "María", "González Pérez", "mgonzalez@estudiante.com", "8765-4321"
        );

        try {
            curso.agregarEstudiante(estudiante1);
            curso.agregarEstudiante(estudiante2); // Esto lanzará una excepción
        } catch (EstudanteDuplicado | CursoLleno e) {
            System.out.println(e.getMessage());
        }

        // Crear matrículas
        Matricula matricula1 = new Matricula(estudiante1, curso);
        Matricula matricula2 = new Matricula(estudiante2, curso);

        // Mostrar información
        System.out.println("\n Profesor:");
        System.out.println(profesor);

        System.out.println("\n Curso:");
        System.out.println(curso);

        System.out.println("\n Estudiantes:");
        System.out.println(estudiante1);
        System.out.println(estudiante2);

        System.out.println("\n Matrículas:");
        System.out.println(matricula1);
        System.out.println(matricula2);

        System.out.println("\n Estudiantes en el curso:");
        for (Estudiante est : curso.getListaEstudiantes()) {
            System.out.println(" " + est.getNombreCompleto());
        }
    } 
 }
    
