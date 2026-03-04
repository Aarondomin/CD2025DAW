public class Persona {

    private String nombre;
    private int edad;

    /** 
     *  Constructor para crear una persona
     * 
     * @param nombre Nombre que se le va a poner
     * @param edad Los años que tiene
     * 
     * 
    */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /** 
     * @return Nombre del uuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre Introduce el nuevo noombre del usuario
     */

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return La edad del usuario
     */

    public int getEdad() {
        return edad;
    }

    /**
     * 
     * @param edad Introduce la nueva edad del usuario
     */

    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Imprime el nombre y la edad del usuario
     */

    public void imprimirDetalles() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }
}
