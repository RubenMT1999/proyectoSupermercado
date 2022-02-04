package modelos;

import java.util.List;
import java.util.Objects;

public class Empresa {

    private int identificador;
    private static int idSiguiente;
    private String codigoEmpresa;
    private List<Empleado> empleados;
    private TipoEmpresa tipoEmpresa;


    public Empresa() {
        this.identificador = ++idSiguiente;
    }


    public Empresa(String codigoEmpresa, List<Empleado> empleados, TipoEmpresa tipoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
        this.empleados = empleados;
        this.tipoEmpresa = tipoEmpresa;
        this.identificador = ++idSiguiente;
    }


    public Empresa(Empresa empresa){
        this.identificador = ++idSiguiente;
        this.codigoEmpresa = empresa.getCodigoEmpresa();
        this.empleados = empresa.getEmpleados();
        this.tipoEmpresa = empresa.getTipoEmpresa();
    }



    public int getIdentificador() {
        return identificador;
    }


    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
    }


    @Override
    public String toString() {
        return "Empresa{" +
                "identificador=" + identificador +
                ", codigoEmpresa='" + codigoEmpresa + '\'' +
                ", tipoEmpresa=" + tipoEmpresa +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return identificador == empresa.identificador && Objects.equals(codigoEmpresa, empresa.codigoEmpresa) && Objects.equals(empleados, empresa.empleados) && tipoEmpresa == empresa.tipoEmpresa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, codigoEmpresa, tipoEmpresa);
    }
}
