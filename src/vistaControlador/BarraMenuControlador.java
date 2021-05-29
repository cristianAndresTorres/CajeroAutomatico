/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cajero;
import vistaComponentes.BarraMenu;

/**
 *
 * @author 57301
 */
public class BarraMenuControlador implements ActionListener{
    //Atributos
    private BarraMenu barraMenu;
    private Cajero cj;
    private VistaControlador vc;
    private CentralPanelControlador centralPanelControlador;
    
    //-------------------------------------------------------------------
    //Constructor
    public BarraMenuControlador(Cajero cj,VistaControlador vc){
        barraMenu = new BarraMenu(this);
        this.cj=cj;
        this.vc=vc;
    }
    //-------------------------------------------------------------------
    
    //Metodos getters and setters
    public BarraMenu getBarraMenu(){
        return barraMenu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(vc.getEstadoOperacion()==2){
            if (e.getSource() == barraMenu.getJbtnConsulta()) {
                vc.setEstadoOperacion(3);
                vc.paso_Continuar();
            }
            if (e.getSource() == barraMenu.getJbtnRetirar()) {
                centralPanelControlador = new CentralPanelControlador(vc);
               
                vc.getVistaPrincipal().getJpCENTRAL().add(centralPanelControlador.panelCentral);
                vc.getVistaPrincipal().repaint();
                
                vc.setEstadoOperacion(4);
                vc.paso_Continuar();
                
            }
            if (e.getSource() == barraMenu.getJbtnTransferir()) {
                vc.setEstadoOperacion(8);
                vc.paso_Continuar();
            }
        }
    
        
    
    
    }
    
}
