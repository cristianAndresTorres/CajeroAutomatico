/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;


import controlador_BD.BD_Acceso;
import modelo.Cuenta;
import operaciones.Operacion;

/**
 *
 * @author Alba
 */
public class Consultar extends Operacion{
    
    
    public Consultar (Cuenta a,BD_Acceso bd){
        super.setCuenta(a);
        super.setBd(bd);
    }
    
    
    
    public String report(){
        String a="";
        
        a="Su saldo actual es de "+super.getCuenta().getSaldo();
        
        return a;
    }
    
}
