/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 57301
 */
public class Cuenta {
    //Atributos
    private boolean estado;
    private int id_cuenta;
    private double saldo;
    private double saldo_Acu_Diario;
    private int tipo_Cuenta;
    private int id_tarjeta;
    
    //Constructor
    public Cuenta(){};
    
    //--------------------------------------------------------------------------------------------------------------
    //Metodos getters y setters
    //--------------------------------------------------------------------------------------------------------------
    
    public double getSaldo_Acu_Diario() {
        return saldo_Acu_Diario;}

    public void setSaldo_Acu_Diario(double saldo_Acu_Diario) {
        this.saldo_Acu_Diario = saldo_Acu_Diario;
    }

    public int getTipo_Cuenta() {
        return tipo_Cuenta;
    }

    public void setTipo_Cuenta(int tipo_Cuenta) {
        this.tipo_Cuenta = tipo_Cuenta;
    }

    public int getId_tarjeta() {
        return id_tarjeta;
    }

    //--------------------------------------------------------------------------------------------------------------
    //Metodos getters y setters
    //--------------------------------------------------------------------------------------------------------------
    public void setId_tarjeta(int id_tarjeta) {
        this.id_tarjeta = id_tarjeta;
    }

    public double getSaldoAcuDiario() {
        return saldo_Acu_Diario;
    }

    public void setSaldoAcuDiario(double saldo_Acu_Diario) {
        this.saldo_Acu_Diario = saldo_Acu_Diario;}
    
    public boolean getEstado() {
        return estado;}
    
    public void setEstado(boolean estado) {
        this.estado = estado;}

    public int getId_cuenta() {
        return id_cuenta;}

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;}

    public double getSaldo() {
        return saldo;}

    public void setSaldo(double saldo) {
        this.saldo = saldo;}

    public int getTipoCuenta() {
        return tipo_Cuenta;}

    public void setTipoCuenta(int tipo_Cuenta) {
        this.tipo_Cuenta = tipo_Cuenta;}
      
}
