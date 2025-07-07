
package Clases;


abstract class Persona {
      private String nombres;
    private String apellidos;
    private String email;
    private String telefono;

    public Persona(String nombres, String apellidos, String email, String telefono) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
    }

   
  enum TipoContrato {
    TIEMPO_COMPLETO,
    POR_HORAS
    }
}
