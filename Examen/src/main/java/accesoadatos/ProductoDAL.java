/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesoadatos;

import entidades.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author MINEDUCYT
 */
public class ProductoDAL {
    public static int crear(Producto producto) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Productos (Nombre, Descripcion, Precio, Existencia, CategoriaId VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setDouble(3, producto.getPrecio());
                statement.setInt(4, producto.getExistencia());
                statement.setInt(5, producto.getCategoriaId());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int modificar(Producto producto) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Productos SET Nombre=?, Descripcion=?, Precio=?, Existencia=?, getCategoriaId=? WHERE ProductoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, producto.getNombre());
                statement.setString(2, producto.getDescripcion());
                statement.setDouble(3, producto.getPrecio());
                statement.setInt(4, producto.getExistencia());
                statement.setInt(5, producto.getCategoriaId());
                statement.setInt(6, producto.getProductoID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public static int eliminar(Producto producto) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Productos WHERE ProductoID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, producto.getProductoID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
    public class CategoriaDAL {
    public static ArrayList<Producto> buscar(Producto productoSearch) {
        ArrayList<Producto> productos = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT ProductoID, Nombre, Descripcion, Precio, Existencia, CategoriaID FROM Productos WHERE Nombre LIKE ?";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + productoSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Producto producto = new Producto();
                        producto.setProductoID(resultSet.getInt("ProductoID"));
                        producto.setNombre(resultSet.getString("Nombre"));
                        producto.setDescripcion(resultSet.getString("Descripcion"));
                        producto.setPrecio(resultSet.getDouble("Precio"));
                        producto.setExistencia(resultSet.getInt("Existencia"));
                        producto.setCategoriaId(resultSet.getInt("CategoriaID"));
                        productos.add(producto);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar el producto", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return productos;
    }
}
}
