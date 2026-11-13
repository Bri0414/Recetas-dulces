package controlador;

import conexion.ConexionBD;
import modelo.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) con las operaciones CRUD (Inserción, Consulta, Actualización y Eliminación)
 * para la entidad Receta utilizando JDBC.
 */
public class RecetaDAO {

    // 1. INSERCIÓN (Create)
    public boolean insertarReceta(Receta receta) {
        String sql = "INSERT INTO recetas (nombre_receta, categoria, ingredientes, preparacion, tiempo_preparacion_min) VALUES (?, ?, ?, ?, ?)";
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, receta.getNombreReceta());
            pstmt.setString(2, receta.getCategoria());
            pstmt.setString(3, receta.getIngredientes());
            pstmt.setString(4, receta.getPreparacion());
            pstmt.setInt(5, receta.getTiempoPreparacionMin());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al insertar la receta: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTA GENERAL (Read All)
    public List<Receta> consultarTodasLasRecetas() {
        List<Receta> listaRecetas = new ArrayList<>();
        String sql = "SELECT * FROM recetas";

        try (Connection conexion = ConexionBD.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Receta receta = new Receta();
                receta.setIdReceta(rs.getInt("id_receta"));
                receta.setNombreReceta(rs.getString("nombre_receta"));
                receta.setCategoria(rs.getString("categoria"));
                receta.setIngredientes(rs.getString("ingredientes"));
                receta.setPreparacion(rs.getString("preparacion"));
                receta.setTiempoPreparacionMin(rs.getInt("tiempo_preparacion_min"));
                listaRecetas.add(receta);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar las recetas: " + e.getMessage());
        }
        return listaRecetas;
    }

    // 2.1 CONSULTA POR ID (Read By ID)
    public Receta consultarRecetaPorId(int idReceta) {
        Receta receta = null;
        String sql = "SELECT * FROM recetas WHERE id_receta = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idReceta);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    receta = new Receta();
                    receta.setIdReceta(rs.getInt("id_receta"));
                    receta.setNombreReceta(rs.getString("nombre_receta"));
                    receta.setCategoria(rs.getString("categoria"));
                    receta.setIngredientes(rs.getString("ingredientes"));
                    receta.setPreparacion(rs.getString("preparacion"));
                    receta.setTiempoPreparacionMin(rs.getInt("tiempo_preparacion_min"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar receta por ID: " + e.getMessage());
        }
        return receta;
    }

    // 3. ACTUALIZACIÓN (Update)
    public boolean actualizarReceta(Receta receta) {
        String sql = "UPDATE recetas SET nombre_receta = ?, categoria = ?, ingredientes = ?, preparacion = ?, tiempo_preparacion_min = ? WHERE id_receta = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setString(1, receta.getNombreReceta());
            pstmt.setString(2, receta.getCategoria());
            pstmt.setString(3, receta.getIngredientes());
            pstmt.setString(4, receta.getPreparacion());
            pstmt.setInt(5, receta.getTiempoPreparacionMin());
            pstmt.setInt(6, receta.getIdReceta());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar la receta: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINACIÓN (Delete)
    public boolean eliminarReceta(int idReceta) {
        String sql = "DELETE FROM recetas WHERE id_receta = ?";

        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement pstmt = conexion.prepareStatement(sql)) {

            pstmt.setInt(1, idReceta);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar la receta: " + e.getMessage());
            return false;
        }
    }
}
