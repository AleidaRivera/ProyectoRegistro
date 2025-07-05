
package Clases;


public class Cursos {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int profesor;
    private int capacidadMaxima;
   
    public Cursos (int codigo, String nombre, String descripcion, int profesor, int capacidadMaxima) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.profesor = profesor;
        this.capacidadMaxima = capacidadMaxima;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
   
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }     

    @Override
    public String toString() {
        return "Cursos{" + "codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", profesor=" + profesor + ", capacidadMaxima=" + capacidadMaxima + '}';
    }
 }
   

