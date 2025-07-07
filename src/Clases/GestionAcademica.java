
package Clases;

import Excepciones.CursoDuplicado;
import Excepciones.ProfesorDuplicado;
import Interface.Procesable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionAcademica implements Procesable {
    
    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Cursos> cursos = new ArrayList<>();
    private final List<Matricula> matriculas = new ArrayList<>();
    
    
    @Override
    public boolean registrarEstudiante(Estudiante estudiante) {
        if (estudiante == null || estudiante.getCarnet() == null || estudiante.getCarnet().trim().isEmpty()) {
            return false;
        }
        
       
        if (buscarEstudiantePorCarnet(estudiante.getCarnet()) != null) {
            return false; 
        }
        
        return estudiantes.add(estudiante);
    }

    @Override
    public Estudiante buscarEstudiantePorCarnet(String carnet) {
        if (carnet == null || carnet.trim().isEmpty()) {
            return null;
        }
        
        for (Estudiante estudiante : estudiantes) {
            if (carnet.equals(estudiante.getCarnet())) {
                return estudiante;
            }
        }
        return null;
    }

    @Override
    public List<Estudiante> obtenerTodosLosEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    @Override
    public boolean actualizarEstudiante(Estudiante estudiante) {
        if (estudiante == null || estudiante.getCarnet() == null || estudiante.getCarnet().trim().isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiante.getCarnet().equals(estudiantes.get(i).getCarnet())) {
                estudiantes.set(i, estudiante);
                return true;
            }
        }
        return false; 
    }

    @Override
    public boolean eliminarEstudiante(String carnet) {
        if (carnet == null || carnet.trim().isEmpty()) {
            return false;
        }
        
     
        matriculas.removeIf(m -> carnet.equals(m.getEstudiante()));
        
      
        return estudiantes.removeIf(e -> carnet.equals(e.getCarnet()));
    }

   
    @Override
    public boolean registrarProfesor(Profesor profesor) {
        if (profesor == null || profesor.getIdProfesor() == null || profesor.getIdProfesor().trim().isEmpty()) {
            return false;
        }
        
       
       
    if (buscarProfesorPorId(profesor.getIdProfesor()) != null) {
            try {
                throw new ProfesorDuplicado("Ya existe un profesor con el ID: " + profesor.getIdProfesor());
            } catch (ProfesorDuplicado ex) {
                Logger.getLogger(GestionAcademica.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                System.out.println("No se puede crear un Profesor con el mismo ID intente con otro id diferente");
            }
    }
        
        return profesores.add(profesor);
    }

    @Override
    public Profesor buscarProfesorPorId(String idProfesor) {
        if (idProfesor == null || idProfesor.trim().isEmpty()) {
            return null;
        }
        
        for (Profesor profesor : profesores) {
            if (idProfesor.equals(profesor.getIdProfesor())) {
                return profesor;
            }
        }
        return null;
    }

    @Override
    public List<Profesor> obtenerTodosLosProfesores() {
        return new ArrayList<>(profesores);
    }

    @Override
    public boolean actualizarProfesor(Profesor profesor) {
        if (profesor == null || profesor.getIdProfesor() == null || profesor.getIdProfesor().trim().isEmpty()) {
            return false;
        }
        
        for (int i = 0; i < profesores.size(); i++) {
            if (profesor.getIdProfesor().equals(profesores.get(i).getIdProfesor())) {
                profesores.set(i, profesor);
                return true;
            }
        }
        return false; 
    }

    @Override
    public boolean eliminarProfesor(String idProfesor) {
        if (idProfesor == null || idProfesor.trim().isEmpty()) {
            return false;
        }
        
      
        try {
            int idProfesorInt = Integer.parseInt(idProfesor);
            boolean tieneCursosAsignados = false;
            
            for (Cursos curso : cursos) {
                if (curso.getCapacidadMaxima()== idProfesorInt) {
                    tieneCursosAsignados = true;
                    break;
                }
            }
            
            if (tieneCursosAsignados) {
                return false; 
            }
        } catch (NumberFormatException e) {
           
        }
        
        return profesores.removeIf(p -> idProfesor.equals(p.getIdProfesor()));
    }

   
    @Override
    public boolean crearCurso(Cursos curso) {
        if (curso == null) {
            return false;
        }
        
         if (buscarCursoPorCodigo(String.valueOf(curso.getCodigo())) != null) {
            try {
                throw new CursoDuplicado("Ya existe un curso con el código: " + curso.getCodigo());
            } catch (CursoDuplicado ex) {
                Logger.getLogger(GestionAcademica.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally{
                System.out.println ("Lo sentimos no se puede crear un curso duplicado");
            }
    }
     
        boolean profesorExiste = false;
        for (Profesor profesor : profesores) {
            try {
                if (Integer.parseInt(profesor.getIdProfesor()) == curso.getCapacidadMaxima()) {
                    profesorExiste = true;
                    break;
                }
            } catch (NumberFormatException e) {
            }
        }
        
        if (!profesorExiste) {
            return false; // El profesor no existe
        }
        
        return cursos.add(curso);
    }

    @Override
    public Cursos buscarCursoPorCodigo(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return null;
        }
        
        try {
            int codigoInt = Integer.parseInt(codigo);
            for (Cursos curso : cursos) {
                if (curso.getCodigo() == codigoInt) {
                    return curso;
                }
            }
        } catch (NumberFormatException e) {
            return null;
        }
        
        return null;
    }

    @Override
    public List<Cursos> obtenerTodosLosCursos() {
        return new ArrayList<>(cursos);
    }

    @Override
    public boolean actualizarCurso(Cursos curso) {
        if (curso == null) {
            return false;
        }
        
        for (int i = 0; i < cursos.size(); i++) {
            if (curso.getCodigo() == cursos.get(i).getCodigo()) {
                cursos.set(i, curso);
                return true;
            }
        }
        return false; // Curso no encontrado
    }

    @Override
    public boolean eliminarCurso(String codigo) {
        if (codigo == null || codigo.trim().isEmpty()) {
            return false;
        }
        
        try {
            int codigoInt = Integer.parseInt(codigo);
            
           
            matriculas.removeIf(m -> String.valueOf(codigoInt).equals(m.getCurso()));
            
            
            return cursos.removeIf(c -> c.getCodigo() == codigoInt);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    
    @Override
    public boolean matricularEstudiante(String carnetEstudiante, String codigoCurso) {
        if (carnetEstudiante == null || carnetEstudiante.trim().isEmpty() || 
            codigoCurso == null || codigoCurso.trim().isEmpty()) {
            return false;
        }
        
       
        if (buscarEstudiantePorCarnet(carnetEstudiante) == null) {
            return false;
        }
        
       
        Cursos curso = buscarCursoPorCodigo(codigoCurso);
        if (curso == null) {
            return false;
        }
        
       
        for (Matricula matricula : matriculas) {
            if (carnetEstudiante.equals(matricula.getEstudiante()) && 
                codigoCurso.equals(matricula.getCurso())) {
                return false; // Ya está matriculado
            }
        }
        
       
        int estudiantesMatriculados = 0;
        for (Matricula matricula : matriculas) {
            if (codigoCurso.equals(matricula.getCurso())) {
                estudiantesMatriculados++;
            }
        }
        
        if (estudiantesMatriculados >= curso.getCapacidadMaxima()) {
            return false; // El curso está lleno
        }
        Estudiante estudiante = buscarEstudiantePorCarnet(carnetEstudiante);
       Cursos cursos = buscarCursoPorCodigo(codigoCurso);

        if (estudiante != null && curso != null) {
        Matricula nuevaMatricula = new Matricula(estudiante, curso, LocalDate.now());
        return matriculas.add(nuevaMatricula);
        } else {
        System.out.println("Estudiante o curso no encontrado.");
        return false;
         }
    }

    @Override
    public boolean desmatricularEstudiante(String carnetEstudiante, String codigoCurso) {
        if (carnetEstudiante == null || carnetEstudiante.trim().isEmpty() || 
            codigoCurso == null || codigoCurso.trim().isEmpty()) {
            return false;
        }
        
        return matriculas.removeIf(m -> carnetEstudiante.equals(m.getEstudiante()) && 
        codigoCurso.equals(m.getCurso()));
    }

    @Override
    public List<Matricula> obtenerMatriculasPorEstudiante(String carnetEstudiante) {
        List<Matricula> resultado = new ArrayList<>();
        
        if (carnetEstudiante == null || carnetEstudiante.trim().isEmpty()) {
            return resultado;
        }
        
        for (Matricula matricula : matriculas) {
            if (carnetEstudiante.equals(matricula.getEstudiante())) {
                resultado.add(matricula);
            }
        }
        
        return resultado;
    }

    @Override
    public List<Matricula> obtenerMatriculasPorCurso(String codigoCurso) {
        List<Matricula> resultado = new ArrayList<>();
        
        if (codigoCurso == null || codigoCurso.trim().isEmpty()) {
            return resultado;
        }
        
        for (Matricula matricula : matriculas) {
            if (codigoCurso.equals(matricula.getCurso())) {
                resultado.add(matricula);
            }
        }
        
        return resultado;
    }
    
    @Override
    public List<Matricula> obtenerTodasLasMatriculas() {
        return new ArrayList<>(matriculas);
    }
    
    
}
