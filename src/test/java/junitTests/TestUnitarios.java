package junitTests;

import modelos.*;
import org.junit.Test;
import utilidades.UtilidadesEmpresa;
import utilidades.UtilidadesFactura;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestUnitarios {




    /* UtilidadesFactura */

    @Test
    public void testCalculoTotalaPagar(){



        Factura factura1 = new Factura("H45",10.0,2.5,21,3.4, LocalDate.of(2020,04,9),
                LocalDate.of(2020,8,12),true,null,null);

        Double prueba = UtilidadesFactura.calcularTotalAPagar(factura1);
        Double prueba2 = 9.075;

        assertEquals(prueba2,prueba);

    }


    /* UtilidadesEmpresa */

    @Test
    public void testGastoTotalCliente(){

        Cliente cliente1 = new Cliente("18139473L","Rubén","Matías","Calle Pacheco", TipoCliente.EMPRESA);
        Cliente cliente2 = new Cliente("37268193P","Antonio","Ruiz","Calle Chicle",TipoCliente.PARTICULAR);

        Factura factura1 = new Factura("H45",10,2.5,21,3.4,LocalDate.of(2020,04,9),
                LocalDate.of(2020,8,12),true,null,cliente1);
        Factura factura2 = new Factura("K01",15,4.25,21,6,LocalDate.of(2020,04,9),
                LocalDate.of(2020,8,12),true,null,cliente1);
        Factura factura3 = new Factura("L90",32,2.5,21,3.1,LocalDate.of(2020,04,9),
                LocalDate.of(2020,8,12),true,null,cliente2);


        List<Factura> miLista = new ArrayList<>();
        miLista.add(factura1);
        miLista.add(factura2);
        miLista.add(factura3);

        Double prueba1 = UtilidadesEmpresa.gastoTotalCliente(miLista, cliente1);
        Double prueba2 = 22.0825;

        assertEquals(prueba2,prueba1);
    }




    @Test
    public void testMejoresPagadosPorEmpresa(){

        Contrato miContrato1 = new Contrato(1200,TipoContrato.PRACTICAS);
        Contrato miContrato2 = new Contrato(1400,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato3 = new Contrato(2000,TipoContrato.PRACTICAS);
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
        misEmpleados2.add(empleado5);
        misEmpleados2.add(empleado6);
        misEmpleados2.add(empleado7);
        misEmpleados2.add(empleado8);

        Empresa empresa1 = new Empresa("HJP01",misEmpleados,TipoEmpresa.PYME);
        Empresa empresa2 = new Empresa("KSK29",misEmpleados2,TipoEmpresa.NACIONAL);

        empleado1.setEmpresa(empresa1);
        empleado2.setEmpresa(empresa1);
        empleado3.setEmpresa(empresa1);
        empleado4.setEmpresa(empresa1);


        empleado5.setEmpresa(empresa2);
        empleado6.setEmpresa(empresa2);
        empleado7.setEmpresa(empresa2);
        empleado8.setEmpresa(empresa2);

        List<Empresa> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(empresa1);
        listaEmpresas.add(empresa2);

        Map<Empresa,Empleado> miMapa1 = UtilidadesEmpresa.getLosMejorPagadosPorEmpresa(listaEmpresas);
        Map<Empresa,Empleado> miMapa2 = new HashMap<>();
        miMapa2.put(empresa1,empleado4);
        miMapa2.put(empresa2,empleado6);

        assertEquals(miMapa2,miMapa1);

    }




    @Test
    public void testEmpleadosPymePracticas(){


        Contrato miContrato1 = new Contrato(1200,TipoContrato.PRACTICAS);
        Contrato miContrato2 = new Contrato(1400,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato3 = new Contrato(2000,TipoContrato.PRACTICAS);
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
        misEmpleados2.add(empleado5);
        misEmpleados2.add(empleado6);
        misEmpleados2.add(empleado7);
        misEmpleados2.add(empleado8);

        Empresa empresa1 = new Empresa("HJP01",misEmpleados,TipoEmpresa.PYME);
        Empresa empresa2 = new Empresa("KSK29",misEmpleados2,TipoEmpresa.NACIONAL);

        empleado1.setEmpresa(empresa1);
        empleado2.setEmpresa(empresa1);
        empleado3.setEmpresa(empresa1);
        empleado4.setEmpresa(empresa1);


        empleado5.setEmpresa(empresa2);
        empleado6.setEmpresa(empresa2);
        empleado7.setEmpresa(empresa2);
        empleado8.setEmpresa(empresa2);

        List<Empresa> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(empresa1);
        listaEmpresas.add(empresa2);

        List<Empleado> listaEmp1 = UtilidadesEmpresa.getEmpleadosPymePracticas(listaEmpresas);
        List<Empleado> listaEmp2 = new ArrayList<>();
        listaEmp2.add(empleado1);
        listaEmp2.add(empleado3);

        assertEquals(listaEmp2,listaEmp1);

    }



    @Test
    public void testEmpleadoTipoContratoLista(){

        Contrato miContrato1 = new Contrato(1200,TipoContrato.PRACTICAS);
        Contrato miContrato2 = new Contrato(1400,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato3 = new Contrato(2000,TipoContrato.PRACTICAS);
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
        misEmpleados2.add(empleado5);
        misEmpleados2.add(empleado6);
        misEmpleados2.add(empleado7);
        misEmpleados2.add(empleado8);

        Empresa empresa1 = new Empresa("HJP01",misEmpleados,TipoEmpresa.PYME);
        Empresa empresa2 = new Empresa("KSK29",misEmpleados2,TipoEmpresa.NACIONAL);

        empleado1.setEmpresa(empresa1);
        empleado2.setEmpresa(empresa1);
        empleado3.setEmpresa(empresa1);
        empleado4.setEmpresa(empresa1);


        empleado5.setEmpresa(empresa2);
        empleado6.setEmpresa(empresa2);
        empleado7.setEmpresa(empresa2);
        empleado8.setEmpresa(empresa2);

        List<Empresa> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(empresa1);
        listaEmpresas.add(empresa2);

        Map<Empresa, Map<TipoContrato, List<Empleado>>> miMapa1 = UtilidadesEmpresa.getEmpleadosPorTipoContratoConLista(listaEmpresas);

        Map<TipoContrato,List<Empleado>> miMapa2 = new HashMap<>();
        Map<Empresa,Map<TipoContrato,List<Empleado>>> miMapa3 = new HashMap<>();

        for (Empresa e : listaEmpresas){

            miMapa2= e.getEmpleados().stream().collect(Collectors.groupingBy(p -> p.getContrato().getTipoContrato()));
            miMapa3.put(e,miMapa2);

        }

        assertEquals(miMapa3,miMapa1);

    }





    @Test
    public void testEmpleadosTipoContrato(){

        Contrato miContrato1 = new Contrato(1200,TipoContrato.PRACTICAS);
        Contrato miContrato2 = new Contrato(1400,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato3 = new Contrato(2000,TipoContrato.PRACTICAS);
        Contrato miContrato4 = new Contrato(3400,TipoContrato.INDEFINIDO);

        Empleado empleado1 = new Empleado("48120454T","Pedro","Fernández","Calle Cóndor",
                "657984501",null,miContrato1);
        Empleado empleado2 = new Empleado("48120499Q","Pepe","López","Calle Abeja",
                "678415609",null,miContrato2);
        Empleado empleado3 = new Empleado("48120499Q","Rocio","Rodiguez","Calle Alcalá",
                "658019934",null,miContrato3);
        Empleado empleado4 = new Empleado("48120499Q","Triana","López","Calle Águila",
                "611458912",null,miContrato4);

        List<Empleado> misEmpleados = new ArrayList<>();
        misEmpleados.add(empleado1);
        misEmpleados.add(empleado2);
        misEmpleados.add(empleado3);
        misEmpleados.add(empleado4);

        List<Empleado> listaPracticas = new ArrayList<>();
        listaPracticas.add(empleado1);
        listaPracticas.add(empleado3);

        List<Empleado> listaObrayServicio = new ArrayList<>();
        listaObrayServicio.add(empleado2);

        List<Empleado> listaIndefinido = new ArrayList<>();
        listaIndefinido.add(empleado4);


        Empresa empresa1 = new Empresa("HJP01",misEmpleados,TipoEmpresa.PYME);

        Map<TipoContrato, List<Empleado>> miMapa1 = UtilidadesEmpresa.getEmpleadosPorTipoContrato(empresa1);

        Map<TipoContrato, List<Empleado>> miMapa2 = new HashMap<>();

        miMapa2.put(TipoContrato.PRACTICAS, listaPracticas);
        miMapa2.put(TipoContrato.OBRAYSERVICIO, listaObrayServicio);
        miMapa2.put(TipoContrato.INDEFINIDO, listaIndefinido);

        assertEquals(miMapa2,miMapa1);

    }



    @Test
    public void testMejorPagado(){

        Contrato miContrato1 = new Contrato(1200,TipoContrato.PRACTICAS);
        Contrato miContrato2 = new Contrato(1400,TipoContrato.OBRAYSERVICIO);
        Contrato miContrato3 = new Contrato(2000,TipoContrato.PRACTICAS);
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
        misEmpleados2.add(empleado5);
        misEmpleados2.add(empleado6);
        misEmpleados2.add(empleado7);
        misEmpleados2.add(empleado8);

        Empresa empresa1 = new Empresa("HJP01",misEmpleados,TipoEmpresa.PYME);
        Empresa empresa2 = new Empresa("KSK29",misEmpleados2,TipoEmpresa.NACIONAL);

        empleado1.setEmpresa(empresa1);
        empleado2.setEmpresa(empresa1);
        empleado3.setEmpresa(empresa1);
        empleado4.setEmpresa(empresa1);


        empleado5.setEmpresa(empresa2);
        empleado6.setEmpresa(empresa2);
        empleado7.setEmpresa(empresa2);
        empleado8.setEmpresa(empresa2);

        List<Empresa> listaEmpresas = new ArrayList<>();
        listaEmpresas.add(empresa1);
        listaEmpresas.add(empresa2);

        Empleado pruebaEmp1 = UtilidadesEmpresa.getMejorPagado(listaEmpresas);
        assertEquals(empleado4,pruebaEmp1);


    }


}
