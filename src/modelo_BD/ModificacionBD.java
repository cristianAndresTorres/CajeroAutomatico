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
import modelo.Cuenta;

/**
 *
 * @author 57301
 */

//Realiza los cambios en la BD del banco
public class ModificacionBD {
    //Atributos
    private Connection miConexion;
    private ConexionBD BDbamco = new ConexionBD();
    private String sqlConsulta;
    private PreparedStatement consulta;
    private ResultSet rsConsulta;
    public ModificacionBD(){};
    //metodos
    
    //int 
    //Modificar--------------------------------------------------------------------------
    public boolean modificar_Cuenta_Retiro(int id_Cuenta, int nuevo_saldo, int nuevo_acumulado) {
        try {
            //1->realizar Conexion
            Connection conexionBD = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            String sqlModificacion = "Update CuentaBancaria set saldo_disponible=?, saldo_retiro=? "+
            " where ID_cuenta=?";

            PreparedStatement consultaUpdate = conexionBD.prepareStatement(sqlModificacion);

            //3-> pasar los parametros
            consultaUpdate.setDouble(1, nuevo_saldo);//(Nuevo saldo disponible en la cuenta);
            consultaUpdate.setDouble(2, nuevo_acumulado);//acumulado diario del dinero a retirar
            consultaUpdate.setString(3, String.valueOf(id_Cuenta));//Id de la cuenta a actualizar

            //4->Terminar sentencia
            consultaUpdate.execute();
            conexionBD.close();
            return true;
        } catch (Exception e) {
            System.out.println("ModificarCuentaRetiro - Update - error");
            return false;
        }
    }

public boolean modificar_Cuenta_Transferencia(int id_cuentaDestino, int nuevo_saldo) {
        try {
            //1->realizar Conexion
            Connection conexionBD = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            String sqlModificacion = "Update CuentaBancaria set saldo_disponible=?"+
            " where ID_cuenta=?";

            PreparedStatement consultaUpdate = conexionBD.prepareStatement(sqlModificacion);

            //3-> pasar los parametros
            consultaUpdate.setDouble(1, nuevo_saldo + this.dineroCuenta(id_cuentaDestino));//saldo_disponible-saldo_retiro);
            consultaUpdate.setString(2, String.valueOf(id_cuentaDestino));//cuanta destino
            
            //4->Terminar sentencia
            consultaUpdate.execute();
            conexionBD.close();
            return true;
        } catch (Exception e) {
            System.out.println("ConsultaProducto - Update - error");
            return false;
        }
    }
    //Trae el dinero de la cuenta destino
    public double dineroCuenta(int id_cuenta){
        double valorActual=0;
        try {
            //1->realizar conexion
            miConexion = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            sqlConsulta = "Select saldo_disponible from CuentaBancaria where ID_cuenta=? and estado_cuenta=1";

            consulta =miConexion.prepareStatement(sqlConsulta);
            //3->Pasar parametro de la consulta
            consulta.setString(1, String.valueOf(id_cuenta));
            
            rsConsulta = consulta.executeQuery();
            //Validación
            if(rsConsulta.next()) {                
                //Validaciones de la cuenta----->
                    System.out.println("Transacción cuenta destino retorno dinero");
                    valorActual = rsConsulta.getDouble("saldo_disponible");
	    }
            rsConsulta.close();
            miConexion.close();
            return valorActual;
        }catch (Exception e) {
            System.out.println("Consulta_CuentaBancaria - Select - error");
            return 0;
	}   
    }
    //Estado ->si esta en funcionamiento o tambien se puede utilizar por si se queda sin algun tipo de billetes
    //Alerta saldo si se queda por debajo del saldo establecido 
    public boolean modificar_Saldo_Cajero(String nitBanco, int nuevo_saldo, int[]cant_Categoria, boolean estado_cajero, boolean alertaSaldo) {
        try {
            //1->realizar Conexion
            Connection conexionBD = BDbamco.realizarConexionBD();
            //2->Preparar consulta
            String sqlModificacion = "Update Cajero set saldo_disponible=?, din_categoria_1=?, din_categoria_2=?, "+
            " din_categoria_3=?, din_categoria_4=?, estado_cajero=?, alertaSaldo=? where ID_cajero=?";

            PreparedStatement consultaUpdate = conexionBD.prepareStatement(sqlModificacion);
            
            //3-> pasar los parametros
            consultaUpdate.setInt(1, nuevo_saldo);//nuevo saldo cajero
            consultaUpdate.setInt(2, cant_Categoria[0]);//cantidad billetes de 10.000
            consultaUpdate.setInt(3, cant_Categoria[1]);//cantidad billetes de 20.000
            consultaUpdate.setInt(4, cant_Categoria[2]);//cantidad billetes de 50.000
            consultaUpdate.setInt(5, cant_Categoria[3]);//cantidad billetes de 100.000
            consultaUpdate.setBoolean(6, estado_cajero);
            consultaUpdate.setBoolean(7, alertaSaldo);
            consultaUpdate.setString(8, nitBanco);
            //4->Terminar sentencia
            consultaUpdate.execute();
            conexionBD.close();
            return true;
        } catch (Exception e) {
            System.out.println("ConsultaProducto - Update - error");
            return false;
        }
    }
 
    
    //Reporte 
    //Registrar------------------------------------------------------------------------
    public boolean generar_Reporte_Transaccion(String informeTransaccion, String codigoCajero) {
            try {
                //1-> realizar conexion
                Connection conexionBD = BDbamco.realizarConexionBD();
                //2-> Preparar Consulta-preParada
                String sqlResgistro = "Insert into ReporteTransferencia (Cajero_ID_cajero, reporteTransaccion)"+
                " values(?,?)";

                PreparedStatement consultaRegristro = conexionBD.prepareStatement(sqlResgistro);

                //3-> Pasar parametros de la consulta
                consultaRegristro.setString(1, codigoCajero);
                consultaRegristro.setString(2, informeTransaccion);
                //4-> realizar modificacion
                consultaRegristro.execute();
                conexionBD.close();
                return true;
            } catch (Exception e) {
                    System.out.println("generar_Reporte_Transaccion - Registro - error");
                    return false;
            }

    }
    
}
