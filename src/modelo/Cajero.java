/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador_BD.BD_Acceso;
import operaciones.Consultar;
import operaciones.Operacion;
import operaciones.Retirar;
import operaciones.Transferir;
import vista.VistaPrincipal;

/**
 *
 * @author Alba
 */
public class Cajero {
    
    private BD_Acceso bd = new BD_Acceso();
    private int []din_categoria;
    private double dinero_dis;
    private Operacion op;
    private boolean papel;
    private VistaPrincipal ven;
    private Cuenta cuenta;
    private boolean estaMontoLimite;
    private String id_cajero="000001"; 
    
    public Cajero(){
        din_categoria= new int[4];
        //Estado inicial del banco
        bd.verificarCajeroAutomatico(this);
        System.out.println(din_categoria[0]);
        System.out.println(din_categoria[1]);
        System.out.println(din_categoria[2]);
        System.out.println(din_categoria[3]);
        System.out.println(dinero_dis);
        System.out.println(papel);
        System.out.println(estaMontoLimite);
        
        
    } 
    
    public void crear_operacion(int op){
    
        if(op == 1){
            this.op = new Consultar(cuenta,bd);
        }else if(op==2){
            this.op = new Transferir(cuenta,bd);
        }else{
            this.op = new Retirar(cuenta,bd);
        }
    }
    //Despues de hacer un retiro se debe actualizar el dinero etc
    public boolean actualizarDatosBanco(){
        boolean estado = bd.verificarCajeroAutomatico(this);
        System.out.println(din_categoria[0]);
        System.out.println(din_categoria[1]);
        System.out.println(din_categoria[2]);
        System.out.println(din_categoria[3]);
        System.out.println(dinero_dis);
        System.out.println(papel);
        System.out.println(estaMontoLimite);
        return estado;
    }
    
    
    public void inform_banco (int tipo){
        
        //consulta
        if(tipo==1){
            bd.getModificaBD().generar_Reporte_Transaccion("La cuenta "+cuenta.getId_cuenta()+" realizo una consulta", id_cajero);
        }
        
        
    }
    
    public boolean ingresar_clave(int tarj,String clave){
        if(bd.getVerificaBD().validar_cuenta(tarj, clave)){
            
            this.cuenta=bd.getVerificaBD().getMiCuenta();
            return true;
        }else{
            return false;
        }
    }
    
    
    
    //aprueba la entrada de la tarjeta
    public boolean ingreso_aprob_tarj(int tarj){
        
        return bd.getVerificaBD().validar_tarjeta(tarj);
    }
    
    
    // get and set////////////////////////////////////////////////////////////////////////////

    public BD_Acceso getBd() {
        return bd;
    }

    public void setBd(BD_Acceso bd) {
        this.bd = bd;
    }

    public int[] getDin_categoria() {
        return din_categoria;
    }

    public void setDin_categoria(int[] din_categoria) {
        this.din_categoria = din_categoria;
    }

    public double getDinero_dis() {
        return dinero_dis;
    }

    public void setDinero_dis(double dinero_dis) {
        this.dinero_dis = dinero_dis;
    }

    public String getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(String id_cajero) {
        this.id_cajero = id_cajero;
    }

    public Operacion getOp() {
        return op;
    }

    public void setOp(Operacion op) {
        this.op = op;
    }

    public boolean isPapel() {
        return papel;
    }

    public void setPapel(boolean papel) {
        this.papel = papel;
    }


    public VistaPrincipal getVen() {
        return ven;
    }

    public void setVen(VistaPrincipal ven) {
        this.ven = ven;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public boolean isEstaMontoLimite() {
        return estaMontoLimite;
    }

    public void setEstaMontoLimite(boolean estaMontoLimite) {
        this.estaMontoLimite = estaMontoLimite;
    }
    
    
    public boolean getEstadoMontoLimite(){
        return this.estaMontoLimite;
    }
    
   
}