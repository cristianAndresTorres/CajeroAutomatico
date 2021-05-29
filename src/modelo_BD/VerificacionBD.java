/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Cajero;
import modelo.Cuenta;

/**
 *
 * @author 57301
 */

//Realiza las validaciones en la BD del banco
public class VerificacionBD {
    //Atributos
    
    private Cuenta miCuenta;
    private Connection miConexion;
    private ConexionBD BDbamco = new ConexionBD();
    private String sqlConsulta;
    private PreparedStatement consulta;
    private boolean estado;
    private ResultSet rsConsulta;
    private int vector[];
    
    public VerificacionBD(){};
    
    //metodos
    //Valida el acceso de la tarjeta
    public boolean validar_tarjeta(int ID_tarjeta){
        try {
            //1->realizar conexion
            miConexion = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            sqlConsulta = "Select * from Tarjeta where ID_tarjeta=? and estado_tarjeta=true and num_intentos<3";

            consulta =miConexion.prepareStatement(sqlConsulta);
            //3->Pasar parametro de la consulta
            consulta.setString(1, String.valueOf(ID_tarjeta));
            
            rsConsulta = consulta.executeQuery();
            //Validación
            if(rsConsulta.next()) {
                estado = true;
                System.out.println("DATOS CORRECTOS");
                System.out.println(rsConsulta.getInt("ID_tarjeta"));
	    }else{
                estado = false;
                System.out.println("ACCESO DENEGADO");
            }
            rsConsulta.close();
            miConexion.close();
            return estado;
        }catch (Exception e) {
            System.out.println("ConsultaTarjeta - Select - error");
            return false;
	}
    }
    
    //Valida el acceso a la cuenta
    public boolean validar_cuenta(int ID_tarjeta, String contrasegna){
        try {
            //1->realizar conexion
            miConexion = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            sqlConsulta = "Select * from CuentaBancaria, Tarjeta where Tarjeta_ID_tarjeta=? and ID_tarjeta=? and contrasegna=? and estado_cuenta=1";

            consulta =miConexion.prepareStatement(sqlConsulta);
            //3->Pasar parametro de la consulta
            consulta.setString(1, String.valueOf(ID_tarjeta));
            consulta.setString(2, String.valueOf(ID_tarjeta));
            consulta.setString(3, contrasegna);
            
            rsConsulta = consulta.executeQuery();
            //Validación
            if(rsConsulta.next()) {
                estado = true;
                System.out.println("CUENTA VALIDADA EXITOSAMENTE");
                System.out.println(rsConsulta.getString("ID_cuenta")+" pss "+rsConsulta.getString("contrasegna"));
                
                this.miCuenta=new Cuenta();
                miCuenta.setEstado(rsConsulta.getBoolean("estado_cuenta")); 
                miCuenta.setId_cuenta(Integer.parseInt(rsConsulta.getString("ID_cuenta")));
                miCuenta.setSaldo(rsConsulta.getDouble("saldo_disponible"));
                miCuenta.setSaldo_Acu_Diario(rsConsulta.getDouble("saldo_retiro"));
                miCuenta.setId_tarjeta(Integer.parseInt(rsConsulta.getString("Tarjeta_ID_tarjeta")));
                miCuenta.setTipoCuenta(Integer.parseInt(rsConsulta.getString("tipo_tarjeta")));  
	    }else{
                estado = false;
                System.out.println("ACCESO DENEGADO");
            }
            rsConsulta.close();
            miConexion.close();
            return estado;
        }catch (Exception e) {
            System.out.println("Consulta_CuentaBancaria - Select - error");
            System.out.println("//NO EXISTE LA CUENTA O ESTA SE ENCUENTRA BLOQUEDA");

            return false;
	}
    }
    
    //Valida el acceso y estado de la cuenta destino
    public boolean validar_cuenta_destino(int id_cuenta){
        try {
            //1->realizar conexion
            miConexion = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            sqlConsulta = "Select * from CuentaBancaria where ID_cuenta=? and estado_cuenta=1";

            consulta =miConexion.prepareStatement(sqlConsulta);
            //3->Pasar parametro de la consulta
            consulta.setString(1, String.valueOf(id_cuenta));
            
            rsConsulta = consulta.executeQuery();
            //Validación
            if(rsConsulta.next()) {                
                //Validaciones de la cuenta----->
                    System.out.println("CUENTA DESTINO VALIDADA EXITOSAMENTE");
                    System.out.println(rsConsulta.getString("ID_cuenta"));
                    estado = true;
	    }else{
                estado = false;
                System.out.println("NO SE ENCUENTRA LA CUENTA");
                System.out.println("//NO EXISTE LA CUENTA O ESTA SE ENCUENTRA BLOQUEDA");
            }
            rsConsulta.close();
            miConexion.close();
            return estado;
        }catch (Exception e) {
            System.out.println("Consulta_CuentaBancaria - Select - error");
            return false;
	}
        
        
    }

    public boolean validar_cajero_Automatico(Cajero miCajero){
        try{
            //1->realizar conexion
            miConexion = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            sqlConsulta = "Select * from Cajero where ID_cajero=? and estado_cajero=1";
            consulta =miConexion.prepareStatement(sqlConsulta);
            //3->Pasar parametro de la consulta
            consulta.setString(1, miCajero.getId_cajero());
            rsConsulta = consulta.executeQuery();
            
            if(rsConsulta.next()) {                
                //Validaciones de la cuenta----->
                    System.out.println("CAJERO VALIDADO EXITOSAMENTE");
                    estado = true;
                     /*
                    private Cuenta cuenta;*/
                    vector = new int[4];
                    vector[0] = rsConsulta.getInt("din_categoria_1");
                    vector[1] = rsConsulta.getInt("din_categoria_2");
                    vector[2] = rsConsulta.getInt("din_categoria_3");
                    vector[3] = rsConsulta.getInt("din_categoria_4");
                    miCajero.setDin_categoria(vector);
                    miCajero.setDinero_dis(rsConsulta.getDouble("saldo_disponible"));
                    miCajero.setPapel(true);
                    miCajero.setEstaMontoLimite(rsConsulta.getBoolean("alertaSaldo"));        
	    }else{
                estado = false;
                System.out.println("NO SE ENCUENTRA EL CAJERO");
            }
            rsConsulta.close();
            miConexion.close();
            return estado;
            //Validación
        }catch(Exception e) {
            System.out.println("Consulta_CuentaBancaria - Select - error");
            return false;
	}   
    }
    
    //--------------------------------------------------------------------------
    //Metodos getters and setters
    public Cuenta getMiCuenta() { return miCuenta;}

    public void setMiCuenta(Cuenta miCuenta) {this.miCuenta = miCuenta;}
    
    
    
}


