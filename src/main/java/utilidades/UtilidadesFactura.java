package utilidades;

import modelos.Factura;
import modelos.LineaFactura;
import modelos.Producto;

import java.time.LocalDate;
import java.util.List;

public class UtilidadesFactura {


    public UtilidadesFactura() {
    }



    public boolean esFacturaVencida(Factura factura){
        LocalDate fecha = factura.getFechaVencimiento();
        boolean devuelve = false;

        if(fecha.isAfter(LocalDate.now()) || fecha.equals(LocalDate.now())){
            devuelve = true;
        }else {
            devuelve = false;
        }

        return devuelve;
    }



    public double calcularBaseFactura(Factura factura){

        List<LineaFactura> miLista = factura.getLineaFactura();
        double importeBase = 0;

        for (int i = 0; i<miLista.size(); i++){

            LineaFactura miLinea =  miLista.get(i);
            Producto miProducto = miLinea.getProducto();
            double precioProducto = miProducto.getPrecio();
            importeBase = importeBase + (miLinea.getCantidad() * precioProducto);
        }

        return importeBase;
    }




    public double calcularTotalAPagar(Factura factura){

        double miImporte = factura.getImporteBase() - factura.getDescuento();
        double pago = miImporte * (factura.getIva() / 100);
        double pagoTotal = miImporte + pago;


        return pagoTotal;

    }
}
