
public class Registro {

    private int id;
    private String ubicacion;
    private String fechaHora;
    private double valor;
    private char unidad;
    private boolean activo;

    public Registro(int id, String ubicacion,
                    String fechaHora, double valor,
                    char unidad, boolean activo) {

        this.id = id;
        this.ubicacion = ubicacion;
        this.fechaHora = fechaHora;
        this.valor = valor;
        this.unidad = unidad;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public double getValor() {
        return valor;
    }

    public char getUnidad() {
        return unidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void mostrar() {
        System.out.println("ID: " + id);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Fecha y hora: " + fechaHora);
        System.out.println("Valor: " + valor);
        System.out.println("Unidad: " + unidad);
        System.out.println("Activo: " + activo);
        System.out.println("-------------------------");
    }
}
