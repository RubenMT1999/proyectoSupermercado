package modelos;

import java.util.Objects;

public class Empleado implements Comparable<Empleado> {

    private int identificador;
    private static int idSiguiente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String numTelefono;
    private Empresa empresa;
    private Contrato contrato;


    public Empleado() {
        this.identificador = ++idSiguiente;
    }


    public Empleado(String dni, String nombre, String apellidos, String direccion, String numTelefono, Empresa empresa, Contrato contrato) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.numTelefono = numTelefono;
        this.empresa = empresa;
        this.contrato = contrato;
        this.identificador = ++idSiguiente;
    }


    public Empleado(Empleado empleado){
        this.identificador = ++idSiguiente;
        this.dni = empleado.getDni();
        this.nombre = empleado.getNombre();
        this.apellidos = empleado.getApellidos();
        this.direccion = empleado.getDireccion();
        this.numTelefono = empleado.getNumTelefono();
        this.empresa = empleado.getEmpresa();
        this.contrato = empleado.getContrato();
    }


    public int getIdentificador() {
        return identificador;
    }



    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public String toString() {
        return "Empleado{" +
                "identificador=" + identificador +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", numTelefono='" + numTelefono + '\'' +

                ", contrato=" + contrato.toString() +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return identificador == empleado.identificador && Objects.equals(dni, empleado.dni) && Objects.equals(nombre, empleado.nombre) && Objects.equals(apellidos, empleado.apellidos) && Objects.equals(direccion, empleado.direccion) && Objects.equals(numTelefono, empleado.numTelefono) && Objects.equals(empresa, empleado.empresa) && Objects.equals(contrato, empleado.contrato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, dni, nombre, apellidos, direccion, numTelefono);
    }

    @Override
    public int compareTo(Empleado o) {
        return (int) (this.getContrato().getSalarioBase() - o.getContrato().getSalarioBase());
    }
}












