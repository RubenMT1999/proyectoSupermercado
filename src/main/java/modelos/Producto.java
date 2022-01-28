
package modelos;

import java.time.LocalDate;
import java.util.Objects;

public class Producto {
    
    private int identificador;
    private static int identificadorSiguiente;
    private String codigo;
    private String descripcion;
    private LocalDate fechaCaducidad;
    private TipoProducto tipo;
    private double precio;
    private Almacen almacen;

    public Producto() {
        identificador = ++identificadorSiguiente;
    }

    public Producto(String codigo, double precio, String descripcion, LocalDate fechaCaducidad, TipoProducto tipo, Almacen almacen) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCaducidad = fechaCaducidad;
        this.tipo = tipo;
        this.almacen = almacen;
        this.precio = precio;
        identificador = ++identificadorSiguiente;
    }


    public Producto(Producto producto){
        identificador = ++identificadorSiguiente;
        this.codigo = producto.getCodigo();
        this.descripcion = producto.getDescripcion();
        this.fechaCaducidad= producto.getFechaCaducidad();
        this.tipo= producto.getTipo();
        this.precio = producto.getPrecio();
        this.almacen = producto.getAlmacen();
    }



    public  int getIdentificador() {
        return identificador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "identificador=" + identificador +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCaducidad=" + fechaCaducidad +
                ", tipo=" + tipo +
                ", precio=" + precio +
                ", almacen=" + almacen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return identificador == producto.identificador && Double.compare(producto.precio, precio) == 0 && Objects.equals(codigo, producto.codigo) && Objects.equals(descripcion, producto.descripcion) && Objects.equals(fechaCaducidad, producto.fechaCaducidad) && tipo == producto.tipo && Objects.equals(almacen, producto.almacen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigo, descripcion, fechaCaducidad, tipo, precio, almacen);
    }
}
