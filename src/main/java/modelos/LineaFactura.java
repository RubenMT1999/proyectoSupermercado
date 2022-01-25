package modelos;

import java.util.Objects;

public class LineaFactura {

    private int identificador;
    private static int IdSiguiente;
    private Factura factura;
    private Producto producto;
    private int cantidad;

    public LineaFactura() {
        this.identificador = ++IdSiguiente;
    }

    public LineaFactura(Factura factura, Producto producto, int cantidad) {
        this.identificador = identificador;
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
        this.identificador = ++IdSiguiente;
    }

    public LineaFactura(LineaFactura e){
        this.identificador = ++IdSiguiente;
        this.factura = getFactura();
        this.producto = getProducto();
        this.cantidad = getCantidad();
    }



    public int getIdentificador() {
        return identificador;
    }


    public static int getIdSiguiente() {
        return IdSiguiente;
    }

    public static void setIdSiguiente(int idSiguiente) {
        IdSiguiente = idSiguiente;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "LineaFactura{" +
                "identificador=" + identificador +
                ", factura=" + factura +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineaFactura that = (LineaFactura) o;
        return identificador == that.identificador && cantidad == that.cantidad && Objects.equals(factura, that.factura) && Objects.equals(producto, that.producto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, factura, producto, cantidad);
    }
}
