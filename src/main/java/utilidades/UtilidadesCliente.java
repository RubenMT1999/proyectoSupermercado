/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;


import modelos.Cliente;

public class UtilidadesCliente {

    public UtilidadesCliente() {
    }


    public boolean esDniValido(Cliente cliente){

        String miDni = cliente.getDni();
        boolean prueba = false;
        boolean devuelve = false;

        for (int i = 0; i<miDni.length(); i++){
            if (Character.isDigit(miDni.charAt(i))){
                prueba = true;
            }
        }

        if (miDni.length() == 8 && Character.isLetter(miDni.charAt(9)) && prueba == true){
            devuelve = true;
        }

        return devuelve;
    }
}
