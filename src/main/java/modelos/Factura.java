package modelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Factura {

    private int identificador;
    private static int idSiguiente;
    private String codigoFactura;
    private double importeBase;
    private double descuento;
    private double iva;
    private double totalAPagar;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private boolean pagada;
    private List<LineaFactura> lineaFactura;
    private Cliente cliente;


    public Factura() {
        this.identificador = ++idSiguiente;
    }

    public Factura(String codigoFactura, double importeBase, double descuento, double iva, double totalAPagar, LocalDate fechaEmision, LocalDate fechaVencimiento, boolean pagada, List<LineaFactura> lineaFactura, Cliente cliente) {
        this.codigoFactura = codigoFactura;
        this.importeBase = importeBase;
        this.descuento = descuento;
        this.iva = iva;
        this.totalAPagar = totalAPagar;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.pagada = pagada;
        this.lineaFactura = lineaFactura;
        this.cliente = cliente;
        this.identificador = ++idSiguiente;
    }

    public Factura(Factura e){
        this.identificador = ++idSiguiente;
        this.codigoFactura = getCodigoFactura();
        this.importeBase = getImporteBase();
        this.descuento = getDescuento();
        this.iva = getIva();
        this.totalAPagar= getTotalAPagar();
        this.fechaEmision = getFechaEmision();
        this.fechaVencimiento= getFechaVencimiento();
        this.pagada = isPagada();
        this.lineaFactura = getLineaFactura();
        this.cliente = getCliente();

    }


    public int getIdentificador() {
        return identificador;
    }



    public static int getIdSiguiente() {
        return idSiguiente;
    }

    public static void setIdSiguiente(int idSiguiente) {
        Factura.idSiguiente = idSiguiente;
    }

    public String getCodigoFactura() {
        return codigoFactura;
    }

    public void setCodigoFactura(String codigoFactura) {
        this.codigoFactura = codigoFactura;
    }

    public double getImporteBase() {
        return importeBase;
    }

    public void setImporteBase(double importeBase) {
        this.importeBase = importeBase;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public List<LineaFactura> getLineaFactura() {
        return lineaFactura;
    }

    public void setLineaFactura(List<LineaFactura> lineaFactura) {
        this.lineaFactura = lineaFactura;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "identificador=" + identificador +
                ", codigoFactura='" + codigoFactura + '\'' +
                ", importeBase=" + importeBase +
                ", descuento=" + descuento +
                ", iva=" + iva +
                ", totalAPagar=" + totalAPagar +
                ", fechaEmision=" + fechaEmision +
                ", fechaVencimiento=" + fechaVencimiento +
                ", pagada=" + pagada +
                ", lineaFactura=" + lineaFactura +
                ", cliente=" + cliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return identificador == factura.identificador && Double.compare(factura.importeBase, importeBase) == 0 && Double.compare(factura.descuento, descuento) == 0 && Double.compare(factura.iva, iva) == 0 && Double.compare(factura.totalAPagar, totalAPagar) == 0 && pagada == factura.pagada && Objects.equals(codigoFactura, factura.codigoFactura) && Objects.equals(fechaEmision, factura.fechaEmision) && Objects.equals(fechaVencimiento, factura.fechaVencimiento) && Objects.equals(lineaFactura, factura.lineaFactura) && Objects.equals(cliente, factura.cliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigoFactura, importeBase, descuento, iva, totalAPagar, fechaEmision, fechaVencimiento, pagada, lineaFactura, cliente);
    }
}
