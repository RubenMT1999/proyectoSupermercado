
package modelos;

import java.util.Objects;

/**
 *
 */
public class Cliente extends Persona{


    /**
     *
     */

    private int identificador;
    private static int identificadorSiguiente;
    private TipoCliente tipo;



    public Cliente() {
        this.identificador = ++identificadorSiguiente;
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, TipoCliente tipo) {
        super(dni, nombre, apellidos, direccion);
        this.tipo = tipo;
        this.identificador = ++identificadorSiguiente;
    }


    @Override
    public int getIdentificador() {
        return identificador;
    }



    public TipoCliente getTipo() {
        return tipo;
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return identificador == cliente.identificador && tipo == cliente.tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), identificador, tipo);
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "identificador=" + identificador +
                ", tipo=" + tipo +
                '}';
    }
}
