
package main;

import modelos.*;
import utilidades.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static modelos.TipoProducto.BEBIDA;
import static modelos.TipoProducto.DROGUERIA;
import static utilidades.UtilidadesEmpresa.getEmpleadosPorContrato;


public class pruebaV1 {
   
    public static void main(String[] args) {
        
      /*  Almacen almacen1= new Almacen("Pepito",400);
        Almacen almacen2 = new Almacen();
        almacen2.setNombre("Sivana");
        almacen2.setCapacidad(500);
        
        System.out.println(almacen1.toString());
        System.out.println(almacen2.toString());
        
        Cliente cliente1 = new Cliente("48139453L","Rubén","Matías","Calle Pacheco",BEBIDA);
        Cliente cliente2 = new Cliente();
        cliente2.setDni("49625198O");
        cliente2.setNombre("Juan");
        cliente2.setApellidos("Espartero");
        cliente2.setDireccion("Condor");
        cliente2.setTipo(DROGUERIA);
        
        System.out.println(cliente1.toString());
        System.out.println(cliente2.toString()); */


        /*Prueba ej 4a.
        Almacen almacen3 = new Almacen("Pepito",4000);

        Cliente cliente1 = new Cliente("48139453L","Rubén","Matías","Calle Pacheco",BEBIDA);

        Producto producto1 = new Producto("JP69",1.50,"Red bull", LocalDate.of(2015,10,11),BEBIDA,almacen3);

        LineaFactura lineaFactura1= new LineaFactura(null, producto1,2);

        Factura factura1 = new Factura("H45",1.50,2.5,21,1.2,LocalDate.of(2020,04,9),
                LocalDate.of(2020,8,12),true,null,cliente1);

        System.out.println(factura1.toString());

        UtilidadesFactura utilidad1= new UtilidadesFactura();
        System.out.println(utilidad1.esFacturaVencida(factura1)); */




        //Prueba ej 4b.

        Almacen almacen3 = new Almacen("Pepito",4000);
        Almacen almacen4 = new Almacen("Grande",10000);

        Cliente cliente1 = new Cliente("18139473L","Rubén","Matías","Calle Pacheco",BEBIDA);

        Producto producto1 = new Producto("JP69",1.50,"Red bull", LocalDate.of(2015,10,11),BEBIDA,almacen3);

        Producto producto2 = new Producto("JK01",2.25,"Monster", LocalDate.of(2018,10,11),BEBIDA,almacen4);

        LineaFactura lineaFactura1= new LineaFactura(null, producto1,2);
        LineaFactura lineaFactura2= new LineaFactura(null, producto2,3);
        List<LineaFactura> miLista1 = new ArrayList<>();
        miLista1.add(lineaFactura1);
        miLista1.add(lineaFactura2);

        Factura factura1 = new Factura("H45",0,2.5,21,1.2,LocalDate.of(2020,04,9),
                LocalDate.of(2020,8,12),true,miLista1,cliente1);


        UtilidadesFactura utilidad1 = new UtilidadesFactura();
        //System.out.println(utilidad1.calcularBaseFactura(factura1));

        factura1.setImporteBase(utilidad1.calcularBaseFactura(factura1));
        //System.out.println(factura1.getImporteBase());

        //Prueba ej 4c.

        //System.out.println(utilidad1.calcularTotalAPagar(factura1));


        //Prueba ej 5a.

        List<Producto> misProductos = new ArrayList<>();
        misProductos.add(producto1);
        misProductos.add(producto2);
        UtilidadesProducto utilidadp1 = new UtilidadesProducto();
        //System.out.println(utilidadp1.getPorTipo(misProductos,BEBIDA));

        //Prueba ej 5b.

       // System.out.println(utilidadp1.getPorAlmacen(misProductos,almacen3));



        //Prueba ej 6.

        //UtilidadesCliente uc1 = new UtilidadesCliente();
        //System.out.println(uc1.esDniValido(cliente1));



        Contrato miContrato1 = new Contrato(1200,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato2 = new Contrato(1400,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato3 = new Contrato(2000,TipoContrato.TEMPORAL);
        Contrato miContrato4 = new Contrato(3400,TipoContrato.INDEFINIDO);

        Contrato miContrato5 = new Contrato(2300,TipoContrato.INDEFINIDO);
        Contrato miContrato6 = new Contrato(3100,TipoContrato.INDEFINIDO);
        Contrato miContrato7 = new Contrato(1000,TipoContrato.TEMPORAL);
        Contrato miContrato8 = new Contrato(1300,TipoContrato.OBRAYSERVICIO);

        Empleado empleado1 = new Empleado("48120454T","Pedro","Fernández","Calle Cóndor",
                "657984501",null,miContrato1);
        Empleado empleado2 = new Empleado("48120499Q","Pepe","López","Calle Abeja",
                "678415609",null,miContrato2);
        Empleado empleado3 = new Empleado("48120499Q","Rocio","Rodiguez","Calle Alcalá",
                "658019934",null,miContrato3);
        Empleado empleado4 = new Empleado("48120499Q","Triana","López","Calle Águila",
                "611458912",null,miContrato4);

        Empleado empleado5 = new Empleado("48120454T","Alejandro","Cabrera","Calle Paz",
                "677889933",null,miContrato5);
        Empleado empleado6 = new Empleado("48120499Q","Luis","Amieva","Calle Mosto",
                "661224422",null,miContrato6);
        Empleado empleado7 = new Empleado("48120499Q","Mercedes","Correa","Calle Santa Marta",
                "677881100",null,miContrato7);
        Empleado empleado8 = new Empleado("48120499Q","Jesús","Nieto","Calle Picasso",
                "6131313",null,miContrato8);

        List<Empleado> misEmpleados = new ArrayList<>();
        misEmpleados.add(empleado1);
        misEmpleados.add(empleado2);
        misEmpleados.add(empleado3);
        misEmpleados.add(empleado4);

        List<Empleado> misEmpleados2 = new ArrayList<>();
        misEmpleados.add(empleado5);
        misEmpleados.add(empleado6);
        misEmpleados.add(empleado7);
        misEmpleados.add(empleado8);

        Empresa empresa1 = new Empresa("HJP01",misEmpleados,TipoEmpresa.STARTUP);
        Empresa empresa2 = new Empresa("KSK29",misEmpleados2,TipoEmpresa.NACIONAL);

        empleado1.setEmpresa(empresa1);
        empleado2.setEmpresa(empresa1);
        empleado3.setEmpresa(empresa1);
        empleado4.setEmpresa(empresa1);
        empresa1.setEmpleados(misEmpleados);

        empleado5.setEmpresa(empresa2);
        empleado6.setEmpresa(empresa2);
        empleado7.setEmpresa(empresa2);
        empleado8.setEmpresa(empresa2);
        empresa2.setEmpleados(misEmpleados2);


        //Prueba ej 3a V2
        //System.out.println(getEmpleadosPorContrato(empresa1,TipoContrato.OBRAYSERVICIO));

        //Prueba ej 3b V2
        //System.out.println(UtilidadesEmpresa.getMileuristasOrdenadosPorSalario(empresa1));

        //Prueba ej 3c V2
        //System.out.println(UtilidadesEmpresa.fondoSalarialEmpresa(empresa1));

        //Prueba ej 3d V2
        List<Empresa> misEmpresas = new ArrayList<>();
        misEmpresas.add(empresa1);
        misEmpresas.add(empresa2);
        //System.out.println(UtilidadesEmpresa.getMejorPagado(misEmpresas));

        //Prueba ej 3e V2
        //System.out.println(UtilidadesEmpresa.getEmpleadosPorTipoContrato(empresa1));

        //Prueba ej 3f V2
        //System.out.println(UtilidadesEmpresa.getEmpleadosPorTipoContratoConLista(misEmpresas));
    }
    
}
