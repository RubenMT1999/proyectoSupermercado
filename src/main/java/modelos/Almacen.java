
package modelos;

import java.util.Objects;


public class Almacen {
    private int identificador;
    private static int idSiguiente;
    private String nombre;
    private int capacidad;

    public Almacen() {
        this.identificador = ++idSiguiente;
    }

    public Almacen(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.identificador = ++idSiguiente;
    }

    public int getIdentificador() {
        return identificador;
    }


    public static int getIdSiguiente() {
        return idSiguiente;
    }

    public static void setIdSiguiente(int idSiguiente) {
        Almacen.idSiguiente = idSiguiente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Almacen{" + "identificador=" + identificador + ", nombre=" + nombre + ", capacidad=" + capacidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.identificador;
        hash = 89 * hash + Objects.hashCode(this.nombre);
        hash = 89 * hash + this.capacidad;
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
        final Almacen other = (Almacen) obj;
        if (this.identificador != other.identificador) {
            return false;
        }
        if (this.capacidad != other.capacidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }
    
    
    

    
    
    

   
    
    
    
    
    
    
}
