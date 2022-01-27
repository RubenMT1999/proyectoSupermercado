/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;


import modelos.Almacen;
import modelos.Producto;
import modelos.TipoProducto;

import java.util.ArrayList;
import java.util.List;

public class UtilidadesProducto {


    public UtilidadesProducto() {
    }



    public List<Producto> getPorTipo(List<Producto> productos, TipoProducto tipo){

        List<Producto> miLista = new ArrayList<>();

        for(Producto e : productos){
            if(e.getTipo().equals(tipo)){
                miLista.add(e);
            }
        }

        return miLista;

    }



    public List<Producto> getPorAlmacen(List<Producto> productos, Almacen almacen){

        List<Producto> miLista = new ArrayList<>();

        for(Producto e : productos){
            if (e.getAlmacen().equals(almacen)){
                miLista.add(e);
            }
        }
        return miLista;
    }


}
