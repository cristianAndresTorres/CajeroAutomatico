/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaControlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import modelo.Cajero;
import vista.VistaPrincipal;
import vistaComponentes.BarraMenu;
import vistaComponentes.PanelCentral;

/**
 *
 * @author 57301
 */
public class VistaControlador{
    //Atributos
    private VistaPrincipal vistaPrincipal;
    
    //Declaracion de los controladores para los componentes
    private BarraMenuControlador barraControlador;
    private BarraMenuDosControlador barraControladorDos;
    private TecladoControlador tecladoControlador;
    private Cajero cj;
    private CentralPanelControlador centralPanelControlador;
     //idicador de a que paso el boton continuar ejecuta la funcion correspondiente 
    private int estadoOperacion=0;
    private int consultaRes=0;
    private int int_clave=0;
    private int dineroIng=0;
    private int des=0;
    
    public VistaControlador(){
        
        cj= new Cajero();
        
        
        vistaPrincipal = new VistaPrincipal(this,cj);
        //Partes
        barraControlador = new BarraMenuControlador(cj,this);
        barraControladorDos = new BarraMenuDosControlador(cj,this);
        tecladoControlador = new TecladoControlador(cj,this);
        centralPanelControlador = new CentralPanelControlador(this);
        //AgregarComponentes
        vistaPrincipal.getJpLateralDer_menu().add(barraControlador.getBarraMenu());
        vistaPrincipal.getJpLateralDer_menu().repaint();
        
        vistaPrincipal.getJpLateralIz_menu().add(barraControladorDos.getBarraMenuDos());         
        vistaPrincipal.getJpLateralIz_menu().repaint();
        
        vistaPrincipal.getJpInferior_Teclado().add(tecladoControlador.getBarraMenuDos());         
        vistaPrincipal.getJpInferior_Teclado().repaint();
        
    }
    
    
    public void paso_clave(){
        
        vistaPrincipal.getTex().setText("Ingrese clave");
        vistaPrincipal.getTex().setBounds(100, 300, 99, 44);
        vistaPrincipal.getTex().setVisible(true);
        vistaPrincipal.getJpCENTRAL().add(vistaPrincipal.getTex());
        
        
        vistaPrincipal.getClav().setBounds(200, 300, 99, 44);
        vistaPrincipal.getClav().setVisible(true);
        vistaPrincipal.getJpCENTRAL().add(vistaPrincipal.getClav());
        
        estadoOperacion=1;
        
        vistaPrincipal.getJpCENTRAL().repaint();
        
    }
    
    public void paso_Continuar() {

        switch (estadoOperacion) {
            case 1://ingreso aprobado de la clave
                if (int_clave < 3) {
                    if (cj.ingresar_clave(tecladoControlador.getTarj(), vistaPrincipal.getClav().getText())) {

                        //se muestran todas las opciones
                        barraControlador.getBarraMenu().getJbtnConsulta().setText("Consultar saldo");
                        barraControlador.getBarraMenu().getJbtnTransferir().setText("Transferir");
                        barraControlador.getBarraMenu().getJbtnRetirar().setText("Retirar");
                        barraControlador.getBarraMenu().repaint();

                        vistaPrincipal.getTex().setText("");
                        vistaPrincipal.getTex().setVisible(false);
                        vistaPrincipal.getClav().setText("");
                        vistaPrincipal.getClav().setVisible(false);

                        vistaPrincipal.getJpCENTRAL().repaint();

                        estadoOperacion = 2;

                    } else {
                        JOptionPane.showMessageDialog(null, "clave incorrecta");
                        int_clave++;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "limite de intentos, retire la tarjeta");
                    estadoOperacion=7;
                    this.paso_Continuar();
                }
                
                break;
            case 2:
                break;
            case 3://consulta de saldo
                if (consultaRes < 2) {

                    cj.crear_operacion(1);

                    JOptionPane.showMessageDialog(null, cj.getOp().report());

                    System.out.println(cj.getOp().report());

                    consultaRes++;
                    estadoOperacion = 6;
                    cj.inform_banco(1);
                    this.paso_Continuar();

                } else {
                    JOptionPane.showMessageDialog(null, "limite de consulta, sera retirado del sistema");
                    estadoOperacion = 7;
                    this.paso_Continuar();

                }
                break;
            case 4:  //retirar 1 paso
                vistaPrincipal.getTex().setText("Ingrese monto");
                vistaPrincipal.getTex().setBounds(100, 300, 99, 44);
                vistaPrincipal.getTex().setVisible(true);

                vistaPrincipal.getEntrada().setBounds(200, 300, 99, 44);
                vistaPrincipal.getEntrada().setVisible(true);
                vistaPrincipal.getJpCENTRAL().add(vistaPrincipal.getEntrada());
                estadoOperacion = 5;
                break;
            case 5: //retirar - segundo paso
                if (vistaPrincipal.getEntrada().getText().length() != 0) {
                    dineroIng= Integer.parseInt(vistaPrincipal.getEntrada().getText());
                    if(dineroIng>=10000 && dineroIng <= 300000 && dineroIng%10000==0){
                        
                        cj.crear_operacion(3);
                        
                        //verificar fondos
                        if(cj.getOp().verificar_saldo(dineroIng)){
                            //verificar si puede retirar ese saldo
                            if(cj.getOp().verificar_cambios(dineroIng)){
                                
                                //realizar la operacion
                                JOptionPane.showMessageDialog(null, "Transaccion en proceso");
                                
                                //resta el dinero del cajero 
                                //pos 0==10.000 pos 1=20.000 
                                cj.setDinero_dis(cj.getDinero_dis()-dineroIng);
                                int residuo=dineroIng;
                                int []copia=new int[4];
                                copia=cj.getDin_categoria();
                                int []cop=new int[4];
                                cop[0]=0;
                                cop[1]=0;
                                cop[2]=0;
                                cop[3]=0;
                                int multi=0;
                                while (residuo != 0) {

                                    if (residuo >= 100000) {

                                        multi = residuo / 100000;

                                        if (multi <= copia[3]) {
                                            residuo = residuo - (multi * 100000);
                                            copia[3] = copia[3] - multi;
                                            cop[3]=multi;
                                            multi = 0;
                                        }

                                    } else {

                                        if (residuo >= 50000) {

                                            multi = residuo / 50000;

                                            if (multi <= copia[2]) {
                                                residuo = residuo - (multi * 50000);
                                                copia[2] = copia[2] - multi;
                                                cop[2]=multi;
                                                multi = 0;
                                            }

                                        } else {

                                            if (residuo >= 20000) {
                                                multi = residuo / 20000;

                                                if (multi <= copia[1]) {
                                                    residuo = residuo - (multi * 20000);
                                                    copia[1] = copia[1] - multi;
                                                    cop[1]=multi;
                                                    multi = 0;
                                                }
                                            } else {
                                                multi = residuo / 10000;
                                                residuo = residuo - (multi * 10000);
                                                copia[0] = copia[0] - multi;
                                                cop[0]=multi;
                                                multi = 0;
                                            }

                                        }

                                    }

                                }
                                cj.setDin_categoria(copia);
                                
                                if(cj.getDinero_dis()>=1000000){
                                     cj.getBd().getModificaBD().modificar_Saldo_Cajero(cj.getId_cajero(), (int) cj.getDinero_dis(),
                                                                                  cj.getDin_categoria(), true, true);
                                }else{
                                    cj.getBd().getModificaBD().modificar_Saldo_Cajero(cj.getId_cajero(), (int) cj.getDinero_dis(),
                                                                                  cj.getDin_categoria(), false, false);
                                    cj.getBd().getModificaBD().generar_Reporte_Transaccion("Dinero del cajero insuficiente",cj.getId_cajero());
                                    cj.setEstaMontoLimite(false);
                                }
                               

                                JOptionPane.showMessageDialog(null, "Retire si dinero:$100.000x"+cop[3]+" $50.000x"+
                                                                    +cop[2]+" $20.000x"+cop[1]+" $10.000x"+cop[0]);
                                
                                
                                JOptionPane.showMessageDialog(null, "Transaccion completada con exito, retire el recibo");
                                
                                //se hacen los cambios en la base de datos
                                cj.getOp().realizar_cambios(dineroIng, 0);
                                cj.getBd().getModificaBD().generar_Reporte_Transaccion(cj.getOp().notificar(dineroIng, 0),
                                                                                        cj.getId_cajero());
                                
                                
                                
                                 estadoOperacion=7;
                                this.paso_Continuar();
                                
                            }else{
                                JOptionPane.showMessageDialog(null, "Tope maximo superado, no puede retirar este monto");
                                estadoOperacion=7;
                                this.paso_Continuar();
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
                            estadoOperacion=7;
                            this.paso_Continuar();
                        }
                        
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Valor no valido");
                        estadoOperacion=7;
                        this.paso_Continuar();
                    }
                    

                }else{
                    JOptionPane.showMessageDialog(null, "no ingreso monto");
                    estadoOperacion=7;
                    this.paso_Continuar();
                }
                break;
            case 6:
                vistaPrincipal.getTex().setText("");
                vistaPrincipal.getTex().setBounds(100, 300, 99, 44);
                vistaPrincipal.getTex().setVisible(false);
                vistaPrincipal.getJpCENTRAL().repaint();

                estadoOperacion = 2;
                break;
            case 7://reinicio del sistema
                tecladoControlador.getTeclado().getTarj().setVisible(true);
                tecladoControlador.getTeclado().getNum_tarj().setText("");
                tecladoControlador.getTeclado().getNum_tarj().setVisible(true);

                barraControlador.getBarraMenu().getJbtnConsulta().setText("");
                barraControlador.getBarraMenu().getJbtnTransferir().setText("");
                barraControlador.getBarraMenu().getJbtnRetirar().setText("");
                barraControlador.getBarraMenu().repaint();

                vistaPrincipal.getTex().setText("");
                vistaPrincipal.getTex().setBounds(100, 300, 99, 44);
                vistaPrincipal.getTex().setVisible(false);
                vistaPrincipal.getClav().setText("");
                vistaPrincipal.getClav().setVisible(false);
                vistaPrincipal.getEntrada().setText("");
                vistaPrincipal.getEntrada().setVisible(false);

                vistaPrincipal.getJpCENTRAL().repaint();

                estadoOperacion = 0;
                consultaRes = 0;
                int_clave=0;
                des=0;
                break;
            case 8://tranferencia paso 1
                vistaPrincipal.getTex().setText("Ingrese numero de cuenta destino");
                vistaPrincipal.getTex().setBounds(20, 300, 300, 44);
                vistaPrincipal.getTex().setVisible(true);
                
                vistaPrincipal.getEntrada().setText("");
                vistaPrincipal.getEntrada().setBounds(300, 300, 99, 44);
                vistaPrincipal.getEntrada().setVisible(true);
                vistaPrincipal.getJpCENTRAL().add(vistaPrincipal.getEntrada());

                vistaPrincipal.getJpCENTRAL().repaint();

                estadoOperacion = 9;
                break;
            case 9: // parte 2 de la trasferencia
                
                if(vistaPrincipal.getEntrada().getText().length()!=0){
                    cj.crear_operacion(2);
                    int destino=Integer.parseInt(vistaPrincipal.getEntrada().getText());
                    
                    if(cj.getOp().verificar_destino(destino)){
                        
                        des=Integer.parseInt(vistaPrincipal.getEntrada().getText());
                        JOptionPane.showMessageDialog(null, "Cuenta reconocida");
                        
                        
                        vistaPrincipal.getTex().setText("Monto");
                        vistaPrincipal.getTex().setBounds(100, 300, 99, 44);
                        vistaPrincipal.getTex().setVisible(true);
                        
                        vistaPrincipal.getJpCENTRAL().add(centralPanelControlador.panelCentral);
                        centralPanelControlador.panelCentral.setVisible(true);
                        vistaPrincipal.getJpCENTRAL().repaint();
                        
                        vistaPrincipal.getEntrada().setText("");
                        vistaPrincipal.getEntrada().setBounds(200, 300, 99, 44);
                        vistaPrincipal.getEntrada().setVisible(true);
                        vistaPrincipal.getJpCENTRAL().add(vistaPrincipal.getEntrada());
                        vistaPrincipal.getJpCENTRAL().repaint();
                        
                        estadoOperacion = 10;
                    }else{
                        JOptionPane.showMessageDialog(null, "Cuenta no reconocida");
                        estadoOperacion=7;
                        this.paso_Continuar();
                    }
                    
                    
                }else{
                   
                    JOptionPane.showMessageDialog(null, "Valor no valido");
                    estadoOperacion=7;
                    this.paso_Continuar();
                    
                }
                
                
                break;
            case 10:
                
                if (vistaPrincipal.getEntrada().getText().length() != 0) {

                    dineroIng = Integer.parseInt(vistaPrincipal.getEntrada().getText());
                    if (dineroIng >= 10000 && dineroIng <= 500000 ) {

                        //verificar fondos
                        if (cj.getOp().verificar_saldo(dineroIng)) {
                            //verificar si puede retirar ese saldo
                            if (cj.getOp().verificar_cambios(dineroIng)) {

                                //realizar la operacion
                                JOptionPane.showMessageDialog(null, "Transaccion en proceso");
                                
                                //cambios en la bd
                                cj.getOp().realizar_cambios(dineroIng, des);
                                JOptionPane.showMessageDialog(null, "Transaccion realizada con exito, retire recibo");
                                cj.getBd().getModificaBD().generar_Reporte_Transaccion(cj.getOp().notificar(dineroIng,des),
                                                                                        cj.getId_cajero());
                                
                                
                                estadoOperacion=7;
                                this.paso_Continuar();
                                

                            }else{
                                JOptionPane.showMessageDialog(null, "Limite diario excedido");
                                estadoOperacion=7;
                                this.paso_Continuar();
                            }
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "No tiene el saldo para esta operacion");
                            estadoOperacion=7;
                            this.paso_Continuar();
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Monto no valido");
                        estadoOperacion=7;
                        this.paso_Continuar();
                    }

                } else {
                   JOptionPane.showMessageDialog(null, "Valor no valido"); 
                   estadoOperacion=7;
                   this.paso_Continuar();
                }
                
                
                break;
            default:
                break;
        }

    }

    public VistaPrincipal getVistaPrincipal() {
        return vistaPrincipal;
    }

    public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
    }

    public int getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(int estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }
    
    public boolean funciona(){
        
        return cj.getEstadoMontoLimite();
    }
    
    
    
}
