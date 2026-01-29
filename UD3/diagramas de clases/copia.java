public class copia{

    public int identificador;
    public String estado;
    public libro original;


    public copia(int identificador,libro original, String estado){

        this.identificador = identificador;
        this.original = original;
        this.estado = estado;

    }

    public void prestar(){
        this.estado = "Prestado";
    }

    public void devolver(){
        this.estado = "Devolver";
    }

}