/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaComponentes;

import javax.swing.JButton;
import javax.swing.JPanel;
import vistaComponentesDisegno.ObjDecoradorServicio;
import vistaComponentesDisegno.ObjGraficosServicio;
import vistaControlador.CentralPanelControlador;
/**
 *
 * @author 57301
 */
public class PanelCentral extends JPanel{
    private ObjDecoradorServicio objDer;
    private ObjGraficosServicio obGrafico;
    private CentralPanelControlador centralPanel;
    private JButton jbtn_5, jbtn_100, jbtn_150, jbtn_200, jbtn_250;

    public PanelCentral(CentralPanelControlador centralPanel){
        objDer = ObjDecoradorServicio.obtenerServicio();
        obGrafico = ObjGraficosServicio.getServicioObjeto();
        
        this.centralPanel = centralPanel;
         //Caracteristicas de la ventana
        this.setSize(600, 350);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(objDer.getColorGrisClaro());
        
        crearBotonesMenu();

    }
    
    //Crear botonoes
    public void crearBotonesMenu(){        
        jbtn_5 = obGrafico.crearBoton("50000", 20, 150, 100, 50, null, objDer.getColorVerdeClaro(), objDer.getcMano(), null);
	this.jbtn_5.addActionListener(centralPanel);
	this.add(jbtn_5);
        
        jbtn_100 = obGrafico.crearBoton("100000",121, 150, 100, 50, null, objDer.getColorVerdeClaro(), objDer.getcMano(), null);
	this.jbtn_100.addActionListener(centralPanel);
	this.add(jbtn_100);
        
        jbtn_150 = obGrafico.crearBoton("150000",222, 150, 100, 50, null, objDer.getColorVerdeClaro(), objDer.getcMano(), null);
	this.jbtn_150.addActionListener(centralPanel);
	this.add(jbtn_150);
        
        jbtn_200 = obGrafico.crearBoton("200000",323, 150, 100, 50, null, objDer.getColorVerdeClaro(), objDer.getcMano(), null);
	this.jbtn_200.addActionListener(centralPanel);
	this.add(jbtn_200);
        
        jbtn_250 = obGrafico.crearBoton("250000",424, 150, 100, 50, null, objDer.getColorVerdeClaro(), objDer.getcMano(), null);
	this.jbtn_250.addActionListener(centralPanel);
	this.add(jbtn_250);
    }

    public JButton getJbtn_5() {
        return jbtn_5;
    }

    public void setJbtn_5(JButton jbtn_5) {
        this.jbtn_5 = jbtn_5;
    }

    public JButton getJbtn_100() {
        return jbtn_100;
    }

    public void setJbtn_100(JButton jbtn_100) {
        this.jbtn_100 = jbtn_100;
    }

    public JButton getJbtn_150() {
        return jbtn_150;
    }

    public void setJbtn_150(JButton jbtn_150) {
        this.jbtn_150 = jbtn_150;
    }

    public JButton getJbtn_200() {
        return jbtn_200;
    }

    public void setJbtn_200(JButton jbtn_200) {
        this.jbtn_200 = jbtn_200;
    }

    public JButton getJbtn_250() {
        return jbtn_250;
    }

    public void setJbtn_250(JButton jbtn_250) {
        this.jbtn_250 = jbtn_250;
    }
    
    
    
}
