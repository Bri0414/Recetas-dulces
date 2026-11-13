package modelo;

/**
 * Clase modelo que representa la entidad Receta dentro del sistema de recetas dulces.
 */
public class Receta {
    private int idReceta;
    private String nombreReceta;
    private String categoria;
    private String ingredientes;
    private String preparacion;
    private int tiempoPreparacionMin;

    public Receta() {
    }

    public Receta(int idReceta, String nombreReceta, String categoria, String ingredientes, String preparacion, int tiempoPreparacionMin) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.categoria = categoria;
        this.ingredientes = ingredientes;
        this.preparacion = preparacion;
        this.tiempoPreparacionMin = tiempoPreparacionMin;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getPreparacion() {
        return preparacion;
    }

    public void setPreparacion(String preparacion) {
        this.preparacion = preparacion;
    }

    public int getTiempoPreparacionMin() {
        return tiempoPreparacionMin;
    }

    public void setTiempoPreparacionMin(int tiempoPreparacionMin) {
        this.tiempoPreparacionMin = tiempoPreparacionMin;
    }

    @Override
    public String toString() {
        return "Receta {" +
                "ID=" + idReceta +
                ", Nombre='" + nombreReceta + ''' +
                ", Categoría='" + categoria + ''' +
                ", Tiempo=" + tiempoPreparacionMin + " min" +
                '}';
    }
}
