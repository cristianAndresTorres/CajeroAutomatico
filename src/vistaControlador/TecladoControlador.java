/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Cajero;
import vistaComponentes.Teclado;

/**
 *
 * @author 57301
 */
public class TecladoControlador implements ActionListener{
//Atributos
    private Teclado teclado;
    private Cajero cj;
    private VistaControlador vc;
   
    private int tarj;
    
    //-------------------------------------------------------------------
    //Constructor
    public TecladoControlador(Cajero cj,VistaControlador vc ){
        teclado = new Teclado(this);
        this.cj=cj;
        this.vc=vc;
    }
    //-------------------------------------------------------------------
    
    //Metodos getters and setters
    public Teclado getBarraMenuDos(){
        return teclado;}
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == teclado.getTarj()) {

            if (teclado.getNum_tarj().getText().length() != 0) {

                if (vc.funciona()) {
                    int tarjeta = Integer.parseInt(teclado.getNum_tarj().getText());

                    if (cj.ingreso_aprob_tarj(tarjeta)) {
                        this.tarj = tarjeta;
                        teclado.getTarj().setVisible(false);
                        teclado.getNum_tarj().setVisible(false);
                        vc.paso_clave();

                    } else {
                        JOptionPane.showMessageDialog(null, "Tarjeta no valida");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Sin dinero");
                }

            }

        }

        if (vc.getEstadoOperacion() == 1 || vc.getEstadoOperacion() == 5) {

            if (e.getSource() == teclado.getJbtn_0()) {
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText() + "0");

            }
        
        if(e.getSource()== teclado.getJbtn_1()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"1" );
        }
        if(e.getSource()== teclado.getJbtn_2()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"2" );
        }
        if(e.getSource()== teclado.getJbtn_3()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"3" );
        }
        if(e.getSource()== teclado.getJbtn_4()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"4" );
        }
        if(e.getSource()== teclado.getJbtn_5()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"5" );
        }
        if(e.getSource()== teclado.getJbtn_6()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"6" );
        }
        if(e.getSource()== teclado.getJbtn_7()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"7" );
        }
        if(e.getSource()== teclado.getJbtn_8()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"8" );
        }
        if(e.getSource()== teclado.getJbtn_9()){
                vc.getVistaPrincipal().getClav().setText(vc.getVistaPrincipal().getClav().getText()+"9" );
        }
            
            
            
        }
        
        
        
        if(e.getSource()== teclado.getJbtn_Continuar()){
            
           vc.paso_Continuar();
            
        }
        
        
        if(e.getSource()== teclado.getJbtn_Cancelar()){
            
           if(JOptionPane.showConfirmDialog(null, "¿Seguro que quieres cancelar la transaccion?")==0){
            vc.setEstadoOperacion(7);
            vc.paso_Continuar();  
            vc.getVistaPrincipal().getJpCENTRAL().removeAll();
           } 
           
            
        }
        
    }

    

    public int getTarj() {
        return tarj;
    }

    public void setTarj(int tarj) {
        this.tarj = tarj;
    }

    public Teclado getTeclado() {
        return teclado;
    }

    public void setTeclado(Teclado teclado) {
        this.teclado = teclado;
    }
 
    
    
}
