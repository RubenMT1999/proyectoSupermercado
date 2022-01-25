
package modelos;

import java.util.Objects;

public class Cliente {
    private int identificador;
    private static int identificadorSiguiente;
    private String dni;
    private String nombre;
    private String apellidos;
    private String direccion;
    private TipoProducto tipo;

    public Cliente() {
        identificador = ++identificadorSiguiente;
    }

    public Cliente(String dni, String nombre, String apellidos, String direccion, TipoProducto tipo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.tipo = tipo;
        identificador = ++identificadorSiguiente;
    }

    public int getIdentificador() {
        return identificador;
    }


    public static int getIdentificadorSiguiente() {
        return identificadorSiguiente;
    }

    public static void setIdentificadorSiguiente(int identificadorSiguiente) {
        Cliente.identificadorSiguiente = identificadorSiguiente;
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

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "identificador=" + identificador + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", tipo=" + tipo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.identificador;
        hash = 11 * hash + Objects.hashCode(this.dni);
        hash = 11 * hash + Objects.hashCode(this.nombre);
        hash = 11 * hash + Objects.hashCode(this.apellidos);
        hash = 11 * hash + Objects.hashCode(this.direccion);
        hash = 11 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.identificador != other.identificador) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
