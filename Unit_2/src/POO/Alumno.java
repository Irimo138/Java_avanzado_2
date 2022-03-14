package POO;

public class Alumno extends Persona {

    public Alumno(String nombre, String genero, int edad) {
        super(nombre, genero, edad);
    }

    public Alumno(String nombre, String genero) {
        this(nombre, genero, 18);
    }

    @Override
    public String toString() {
        return super.toString() + " es un Alumno.";
    }
}