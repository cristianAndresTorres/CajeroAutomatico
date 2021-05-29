/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import vistaComponentes.PanelCentral;

/**
 *
 * @author 57301
 */
public class CentralPanelControlador implements ActionListener{
    protected PanelCentral panelCentral;
    private VistaControlador vistaControlador;
    
    public CentralPanelControlador(VistaControlador vistaControlador){
        panelCentral = new PanelCentral(this);
        this.vistaControlador = vistaControlador;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        vistaControlador.getVistaPrincipal().getEntrada().setText(b.getText());
        visibilidad();
        
    }
    public void visibilidad(){
        panelCentral.setVisible(false);
    }
    
}
