/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author MINEDUCYT
 */
public class Categoria {
    private int CategoriaId;
    private String Nombre;
    private String Descripcion;

    public Categoria() {
    }

    public Categoria(int CategoriaId, String Nombre, String Descripcion) {
        this.CategoriaId = CategoriaId;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }

    public int getCategoriaId() {
        return CategoriaId;
    }

    public void setCategoriaId(int CategoriaId) {
        this.CategoriaId = CategoriaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    @Override
    public String toString(){
        return Nombre;
    }
}
