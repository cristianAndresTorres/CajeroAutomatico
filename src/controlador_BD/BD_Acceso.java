/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador_BD;

import modelo.Cajero;
import modelo.Cuenta;
import modelo_BD.ModificacionBD;
import modelo_BD.VerificacionBD;

/**
 *
 * @author 57301
 */
public class BD_Acceso {
    //Atributos
    private ModificacionBD modificaBD;
    private VerificacionBD verificaBD;    
    //Constructor
    public BD_Acceso(){
        modificaBD = new ModificacionBD();
        verificaBD = new VerificacionBD();
    }
    //--------------------------------------------------------------------------
    //Metodo
    //--------------------------------------------------------------------------

    public ModificacionBD getModificaBD() {return modificaBD;}

    public VerificacionBD getVerificaBD() {return verificaBD;}
    
    public boolean verificarCajeroAutomatico(Cajero miCajero){
      return verificaBD.validar_cajero_Automatico(miCajero);
    }

}
