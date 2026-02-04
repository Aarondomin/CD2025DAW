public class Multa {
    public int fechaInicio;
    public int fechaFin;
    public Lector lector;



    public Multa(int fechaInicio, int fechaFin, Multa multa){
        this.fechaInicio = fechaInicio;
        this.fechaInicio = fechaFin;
        this.multa = multa;
    }

    public void calcularFechaFin(){
        this.fechaFin = this.fechaInicio + 15;
    }
}

