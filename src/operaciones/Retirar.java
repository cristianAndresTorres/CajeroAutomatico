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
public class Retirar extends Operacion{
    
    
    public Retirar (Cuenta a,BD_Acceso bd){
        this.setCuenta(a);
        this.setBd(bd);
    }
    
    @Override
    public String notificar(int dinero,int nada){
        String as="La cuenta "+super.getCuenta().getId_cuenta()+" retiro la cantidad de $"+dinero;
        return as ;
    }
    
    @Override
    public void realizar_cambios(int dinero, int nada){
        
        super.getBd().getModificaBD().modificar_Cuenta_Retiro(super.getCuenta().getId_cuenta(), 
                                                                (int) (super.getCuenta().getSaldo()-dinero),
                                                                (int) (super.getCuenta().getSaldo_Acu_Diario()+dinero));
        
        
        
    }
    
    
    
}
