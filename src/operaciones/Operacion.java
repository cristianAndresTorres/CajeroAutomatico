/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;


import controlador_BD.BD_Acceso;
import modelo.Cuenta;

/**
 *
 * @author Alba
 */
public class Operacion {
    
    private BD_Acceso bd;
    private Cuenta cuenta;
    private boolean estado;
    
    
    public boolean fin_operacion(){
     
        return true;
    }
    
    public String notificar(int dinero,int otraCuenta){
        
        return "sd";
    }
    
    public void realizar_cambios(int dinero,int cuentaT){
        
    }
    
    
    public boolean verificar_cambios(int entrada){
        
        if(cuenta.getSaldo_Acu_Diario()+entrada <= 1200000){
            return true;
        }else{
              return false; 
        }
        
    }
    
    
    public boolean verificar_saldo(int entrada){
        
        if(cuenta.getSaldo()>=entrada){
            return true;
        }else{
              return false; 
        }
        
      
    }
    
    public boolean verificar_destino(int des){
        return true;
    }
    
    public String report(){
        String a="";
        return a;
    }
    
    
    
    
    // solo get and set////////////////////////////////////////////////////////////

    public BD_Acceso getBd() {
        return bd;
    }

    public void setBd(BD_Acceso bd) {
        this.bd = bd;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    
}
