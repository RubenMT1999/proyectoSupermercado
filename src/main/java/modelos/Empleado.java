package modelos;

import java.util.Objects;

public class Empleado extends Persona implements Comparable<Empleado>  {

    private int identificador;
    private static int idSiguiente;
    private String numTelefono;
    private Empresa empresa;
    private Contrato contrato;


    public Empleado() {
        this.identificador = ++idSiguiente;
    }

    public Empleado(String dni, String nombre, String apellidos, String direccion, String numTelefono, Empresa empresa, Contrato contrato) {
        super(dni, nombre, apellidos, direccion);
        this.numTelefono = numTelefono;
        this.empresa = empresa;
        this.contrato = contrato;
        this.identificador = ++idSiguiente;
    }

    @Override
    public int getIdentificador() {
        return identificador;
    }


    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Empleado empleado = (Empleado) o;
        return identificador == empleado.identificador && Objects.equals(numTelefono, empleado.numTelefono) && Objects.equals(empresa, empleado.empresa) && Objects.equals(contrato, empleado.contrato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identificador, numTelefono, contrato);

    }


    @Override
    public String toString() {
        return  super.toString()+ "Empleado{" +
                "identificador=" + identificador +
                ", numTelefono='" + numTelefono + '\'' +
                ", contrato=" + contrato +
                '}';
    }

    @Override
    public int compareTo(Empleado o) {
        return (int) (this.getContrato().getSalarioBase() - o.getContrato().getSalarioBase());
    }
}












