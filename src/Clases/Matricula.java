
package Clases;

import java.time.LocalDate;

public class Matricula {
    private Estudiante estudiante;
    private Cursos curso;
    private LocalDate fechaMatricula;

    public Matricula(Estudiante estudiante, Cursos curso, LocalDate fechaMatricula) {
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaMatricula = fechaMatricula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(LocalDate fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Override
    public String toString() {
        return "Matricula{" + "estudiante=" + estudiante + ", curso=" + curso + ", fechaMatricula=" + fechaMatricula + '}';
    }
}
