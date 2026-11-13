package vista;

import controlador.RecetaDAO;
import modelo.Receta;
import java.util.List;

/**
 * Clase principal de ejecución y prueba de las operaciones CRUD del módulo de Recetas Dulces.
 */
public class Main {
    public static void main(String[] args) {
        RecetaDAO recetaDAO = new RecetaDAO();

        System.out.println("=== MÓDULO DE GESTIÓN DE RECETAS DULCES ===");

        // 1. Prueba de Inserción
        Receta nuevaReceta = new Receta(
            0,
            "Postre de Maracuyá",
            "Postres Fríos",
            "250ml crema de leche, 200g leche condensada, 150ml jugo de maracuyá, 1 sobre gelatina sin sabor, galletas ducales",
            "Licuar la crema de leche, leche condensada y jugo de maracuyá. Agregar gelatina hidratada. Armar capas con galletas y refrigerar por 3 horas.",
            25
        );
        if (recetaDAO.insertarReceta(nuevaReceta)) {
            System.out.println("[OK] Receta insertada correctamente.");
        }

        // 2. Prueba de Consulta
        System.out.println("\n--- Listado de Recetas Registradas ---");
        List<Receta> recetas = recetaDAO.consultarTodasLasRecetas();
        for (Receta r : recetas) {
            System.out.println(r);
        }

        // 3. Prueba de Actualización (si existe al menos un registro)
        if (!recetas.isEmpty()) {
            Receta primera = recetas.get(0);
            primera.setTiempoPreparacionMin(30);
            if (recetaDAO.actualizarReceta(primera)) {
                System.out.println("\n[OK] Receta actualizada: " + primera.getNombreReceta());
            }
        }

        // 4. Prueba de Eliminación (ejemplo comentariado para evitar borrar datos de prueba)
        // if (recetaDAO.eliminarReceta(1)) {
        //     System.out.println("[OK] Receta eliminada correctamente.");
        // }
    }
}
