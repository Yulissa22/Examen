/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
public class CategoriaDAL {
    public static ArrayList<Categoria> obtenerTodos() {
        ArrayList<Categoria> categorias = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT CategoriaID, Nombre, Descripcion FROM Categorias";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {                              
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int categoriaId = resultSet.getInt("CategoriaID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");                       
                        Categoria categoria = new Categoria(categoriaId,nombre,descripcion );
                        categorias.add(categoria);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener las categorias", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return categorias;
    }
}
