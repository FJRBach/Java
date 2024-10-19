public class Tarea {
    private String descripcion;

    public Tarea(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return descripcion;
    }
}