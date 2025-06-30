
package Clases;
import Excepciones.CursoLleno;
import Excepciones.EstudanteDuplicado;
import java.util.List;

public class Cursos {
    private String codigo;
    private String nombre;
    private String descripcion;
    private Profesor profesor;
    private int capacidadMaxima;
    private List<Estudiante> listaEstudiantes;

    public Cursos (String codigo, String nombre, String descripcion, Profesor profesor, int capacidadMaxima, List<Estudiante> listaEstudiantes) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.capacidadMaxima = capacidadMaxima;
        this.listaEstudiantes = listaEstudiantes;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public List<Estudiante> getListaEstudiantes() {
        return listaEstudiantes;
    }

    public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {
        this.listaEstudiantes = listaEstudiantes;
    }
    
    // se hicieron cambios en el metodo para mejorar el manejo de estudiantes
  public void agregarEstudiante(Estudiante estudiante) throws EstudanteDuplicado, CursoLleno {
    if (listaEstudiantes.size() >= capacidadMaxima) {
        throw new CursoLleno(" No se puede agregar estudiante, el curso está lleno.");
    }

    for (Estudiante e : listaEstudiantes) {
        if (e.getCarnet().equals(estudiante.getCarnet())) {
            throw new EstudanteDuplicado(" El estudiante con carnet " + estudiante.getCarnet() + " ya está inscrito.");
        }
    }
    listaEstudiantes.add(estudiante);
}
    @Override
    public String toString() {
        return "Curso: " + codigo + " " + nombre + " (" + getCapacidadMaxima() + "" + capacidadMaxima + ")";
    }
}
