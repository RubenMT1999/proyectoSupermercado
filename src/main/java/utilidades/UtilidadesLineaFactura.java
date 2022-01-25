package utilidades;

import modelos.Factura;

import java.time.LocalDate;

public class UtilidadesLineaFactura {

    public UtilidadesLineaFactura() {
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

}
