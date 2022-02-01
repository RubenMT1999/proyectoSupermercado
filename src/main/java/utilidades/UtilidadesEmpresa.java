package utilidades;

import modelos.Empleado;
import modelos.Empresa;
import modelos.TipoContrato;

import java.util.*;

public class UtilidadesEmpresa {

    public UtilidadesEmpresa() {
    }

    public static List<Empleado> getEmpleadosPorContrato(Empresa empresa, TipoContrato tipoContrato){

        List<Empleado> miLista = new ArrayList<>();


        for(Empleado e : empresa.getEmpleados()){
            if (e.getContrato().getTipoContrato() == tipoContrato){
                miLista.add(e);
            }
        }

        return  miLista;

    }



    public List<Empleado> getMileuristasOrdenadosPorSalario(Empresa empresa){

        List<Empleado> miLista = new ArrayList<>();

        for (Empleado e : empresa.getEmpleados()){
            if(e.getContrato().getSalarioBase() >= 1000){
                miLista.add(e);
            }
        }
        Comparator<Integer> comparador = Collections.reverseOrder();
        Collections.sort(miLista,comparador);
    }
}
