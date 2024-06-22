/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author luzne
 */
public class Venta {
    int id;
    String descripcion;
    int cantidad;
    double precio;
    double importe;
    
    public Venta(){
        
    }

    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getImporte() {
        return importe;
    }

    public Venta(int id, String descripcion, double precio, double importe) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.importe = importe;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
            
    
}
