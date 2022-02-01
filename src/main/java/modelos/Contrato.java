package modelos;

import java.util.Objects;

public class Contrato {

    private int identificador;
    private static int idSiguiente;
    private double salarioBase;
    private TipoContrato tipoContrato;


    public Contrato() {
        this.identificador = ++idSiguiente;
    }


    public Contrato(double salarioBase, TipoContrato tipoContrato) {
        this.salarioBase = salarioBase;
        this.tipoContrato = tipoContrato;
        this.identificador=++idSiguiente;
    }


    public Contrato(Contrato contrato){
        this.identificador = ++idSiguiente;
        this.salarioBase = contrato.getSalarioBase();
        this.tipoContrato = contrato.getTipoContrato();
    }



    public int getIdentificador() {
        return identificador;
    }


    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "identificador=" + identificador +
                ", salarioBase=" + salarioBase +
                ", tipoContrato=" + tipoContrato +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contrato contrato = (Contrato) o;
        return identificador == contrato.identificador && Double.compare(contrato.salarioBase, salarioBase) == 0 && tipoContrato == contrato.tipoContrato;
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador, salarioBase, tipoContrato);
    }
}
