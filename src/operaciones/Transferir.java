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
public class Transferir extends Operacion{
    private int num_cuenta_des;

    
    
    public Transferir(Cuenta a,BD_Acceso bd){
        this.setCuenta(a);
        this.setBd(bd);
    }
    
    
    @Override
    public boolean verificar_destino(int des){
        return super.getBd().getVerificaBD().validar_cuenta_destino(des);
    }
    
    
    @Override
    public void realizar_cambios(int dinero,int cuentaT){
        super.getBd().getModificaBD().modificar_Cuenta_Transferencia(cuentaT, dinero);
        super.getBd().getModificaBD().modificar_Cuenta_Retiro(super.getCuenta().getId_cuenta(),
                                                                (int) (super.getCuenta().getSaldo()-dinero),
                                                                (int) (super.getCuenta().getSaldo_Acu_Diario()+dinero));
    }
    
    @Override
     public String notificar(int dinero,int otraCuenta){
        String a="La cuenta "+super.getCuenta().getId_cuenta()+" Transfirio el monto $"+dinero+" a "+otraCuenta;
        return a;
    }
    
    
    
    // set and get///////////////////////////////////////////////7
    public int getNum_cuenta_des() {
        return num_cuenta_des;
    }

    public void setNum_cuenta_des(int num_cuenta_des) {
        this.num_cuenta_des = num_cuenta_des;
    }
    
    
    
    
    
}
