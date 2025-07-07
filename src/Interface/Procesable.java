
package Interface;

import Clases.Cursos;
import Clases.Estudiante;
import Clases.Matricula;
import Clases.Profesor;
import java.util.List;


public interface Procesable {
    boolean registrarEstudiante(Estudiante estudiante); // Metodo para hacer algo
    Estudiante buscarEstudiantePorCarnet(String carnet); // Hace una busqueda interesante 
    List<Estudiante> obtenerTodosLosEstudiantes(); // obtiene la lista de los que se pide 
    boolean actualizarEstudiante(Estudiante estudiante); //Actualiza el registro 
    boolean eliminarEstudiante(String carnet); //Elimina algo importante
    
    
    boolean registrarProfesor(Profesor profesor);
    Profesor buscarProfesorPorId(String idProfesor);
    List<Profesor> obtenerTodosLosProfesores();
    boolean actualizarProfesor(Profesor profesor);
    boolean eliminarProfesor(String idProfesor);
    
   
    boolean crearCurso(Cursos curso);
    Cursos buscarCursoPorCodigo(String codigo);
    List<Cursos> obtenerTodosLosCursos();
    boolean actualizarCurso(Cursos curso);
    boolean eliminarCurso(String codigo);
    
   
    boolean matricularEstudiante(String carnetEstudiante, String codigoCurso);
    boolean desmatricularEstudiante(String carnetEstudiante, String codigoCurso);
    List<Matricula> obtenerMatriculasPorEstudiante(String carnetEstudiante);
    List<Matricula> obtenerMatriculasPorCurso(String codigoCurso);
    List<Matricula> obtenerTodasLasMatriculas();
}
