package utilidades;

import modelos.*;

import java.util.*;
import java.util.stream.Collectors;

public class UtilidadesEmpresa{




    public UtilidadesEmpresa() {
    }


    /**
     * @param empresa
     * @param tipoContrato
     * @return
     */
    public static List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){

        List<Empleado> miLista = new ArrayList<>();


        for(Empleado e : empresa.getEmpleados()){
            if (e.getContrato().getTipoContrato() == tipoContrato){
                miLista.add(e);
            }
        }

        return  miLista;

    }




    public static List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){

        List<Empleado> miLista = new ArrayList<>();

        for (Empleado e : empresa.getEmpleados()){
            if(e.getContrato().getSalarioBase() >= 1000){
                miLista.add(e);
            }
        }
        Collections.sort(miLista,Collections.reverseOrder());
        return miLista;

    }




    public static double fondoSalarialEmpresa(Empresa empresa){

        double cont = 0;

        for(Empleado e : empresa.getEmpleados()){
            cont = cont + e.getContrato().getSalarioBase();
        }
        return cont;
    }



    public static Empleado getMejorPagado(List<Empresa> empresas){

        List<Empleado> miLista = new ArrayList<>();

        for (Empresa e : empresas){
            for (Empleado i : e.getEmpleados()){
                miLista.add(i);
            }
        }

        Collections.sort(miLista,Collections.reverseOrder());

        //miLista.sort(Comparator.comparing(em -> em.getContrato().getSalarioBase()));
        //miLista.get(miLista.size()-1);

        return miLista.get(0);

    }


    /**
     * @param empresas
     * @return
     */
    public static Map<TipoContrato, List<Empleado>> getEmpleadosPorTipoContrato(Empresa empresas){

        List<Empleado> miLista = new ArrayList<>();
        for (Empleado e : empresas.getEmpleados()){
            miLista.add(e);
        }

        Map<TipoContrato, List<Empleado>> miMapa = miLista.stream().collect(Collectors.groupingBy
                (empleado -> empleado.getContrato().getTipoContrato()));

        return miMapa;
    }



    public static Map<Empresa, Map<TipoContrato, List<Empleado>>> getEmpleadosPorTipoContratoConLista(List<Empresa> empresas){


        Map<TipoContrato,List<Empleado>> miMapa1 = new HashMap<>();
        Map<Empresa,Map<TipoContrato,List<Empleado>>> miMapa2 = new HashMap<>();


        for (Empresa e : empresas){

                miMapa1= e.getEmpleados().stream().collect(Collectors.groupingBy(p -> p.getContrato().getTipoContrato()));
                miMapa2.put(e,miMapa1);

        }

        return miMapa2;
    }




    public static List<Empleado> getEmpleadosPymePracticas(List<Empresa> empresas){

        List<Empleado> miLista = new ArrayList<>();

        for (Empresa e : empresas){
            for (Empleado i : e.getEmpleados()){
                if (i.getContrato().getTipoContrato().equals(TipoContrato.PRACTICAS)
                        && e.getTipoEmpresa().equals(TipoEmpresa.PYME)){
                    miLista.add(i);
                }
            }
        }
        return miLista;
    }




    public static Map<Empresa,Empleado>  getLosMejorPagadosPorEmpresa(List<Empresa> empresas){

        List<Empleado> miLista = new ArrayList<>();
        List<Empleado> miLista2 = new ArrayList<>();




        for(Empresa e : empresas){
            for(Empleado i : e.getEmpleados()){

                miLista.add(i);
            }

            Collections.sort(miLista,Collections.reverseOrder());
            miLista2.add(miLista.get(0));
            miLista.clear();
        }

        Map<Empresa, Empleado> miMapa = new HashMap<>() ;

        miLista2.stream().forEach(e-> {
            miMapa.put(e.getEmpresa(), e);
        });

        return miMapa;
    }



    public static Double gastoTotalCliente(List<Factura> facturas, Cliente cliente){

        List<Factura> miLista = new ArrayList<>();

        double cantidad = 0;


        for (Factura f : facturas){
            if (f.getCliente().equals(cliente)){
                miLista.add(f);
            }
        }

        for (Factura m : miLista){
            double prueba = UtilidadesFactura.calcularTotalAPagar(m);
            cantidad = cantidad + prueba;
            prueba = 0;
        }



        return cantidad;
    }


}





















