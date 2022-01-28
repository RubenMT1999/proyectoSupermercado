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
        boolean devuelve = false;
        boolean prueba = false;
        boolean prueba2 = false;
        int contador = 0;


        for(int i=0; i<miDni.length()-1;i++){
            if (Character.isDigit(miDni.charAt(i))){
                contador = contador+1;
            }
        }


        if(contador == 8){
            prueba = true;
        }

        if (Character.isLetter(miDni.charAt(8))){
            prueba2= true;
        }


        if(miDni.length()==9 && prueba==true && prueba2==true){
            devuelve = true;
        }

        return devuelve;
}
}
