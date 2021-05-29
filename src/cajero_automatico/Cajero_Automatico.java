/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajero_automatico;

import java.sql.Connection;
import modelo.Cajero;
import modelo.Cuenta;
import modelo_BD.ConexionBD;
import modelo_BD.ModificacionBD;
import modelo_BD.VerificacionBD;
import vista.VistaPrincipal;
import vistaControlador.VistaControlador;

/**
 *
 * @author 57301
 */
public class Cajero_Automatico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        VistaControlador vistaControlador = new VistaControlador();
        
        
        
        
        
        
        //VerificacionBD bdVerificación = new VerificacionBD();
        //ModificacionBD dbModificacion = new ModificacionBD();
        
        //bdVerificación.validar_tarjeta(23456783);
        //bdVerificación.validar_cuenta(23456789,"0009");
        /*bdVerificación.validar_cuenta_destino(456789);
        
        ModificacionBD dbModificacion = new ModificacionBD();
        dbModificacion.modificar_Cuenta_Retiro(456789, 0, 200000);
        
        dbModificacion.modificar_Cuenta_Transferencia(456783, 500000);
        
        int numero[]={1,1,1,1};
        dbModificacion.modificar_Saldo_Cajero("000001", 180000, numero, true, true);
        
        dbModificacion.generar_Reporte_Transaccion("Hola", "000001");
        
        Cajero cajero = new Cajero();
        int numero[]={100,100,50,50};
        dbModificacion.modificar_Saldo_Cajero("000001", 10500000, numero, true, true);
        cajero.actualizarDatosBanco();
        */
        
        
    }
    
}
