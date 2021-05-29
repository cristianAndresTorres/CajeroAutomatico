/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaComponentes;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPanel;
import vistaComponentesDisegno.ObjDecoradorServicio;
import vistaComponentesDisegno.ObjGraficosServicio;
import vistaControlador.BarraMenuDosControlador;

/**
 *
 * @author 57301
 */
public class BarraMenuDos extends JPanel{
    
    //Crear botones
    private ObjGraficosServicio obGrafico;
    private ObjDecoradorServicio obDecorador2;
    //Atributos
    private JButton jbtnTrabajador;
    private BarraMenuDosControlador barraControlador_2;
    
    public BarraMenuDos(BarraMenuDosControlador barraControlador_2){
        this.barraControlador_2 = barraControlador_2;
        
        obGrafico = ObjGraficosServicio.getServicioObjeto();
        obDecorador2 = ObjDecoradorServicio.obtenerServicio();
        crearBotonesMenu();
        
        //Caracteristicas de la ventana
        this.setSize(100, 350);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(obDecorador2.getColorRojClaro());

    }
    
    //Metodos
    
    //Crear botonoes
    public void crearBotonesMenu(){        
        jbtnTrabajador = obGrafico.crearBoton("", 5, 260, 90, 50, null, obDecorador2.getColorRojOscuro(), obDecorador2.getcMano(), null);
	this.jbtnTrabajador.addActionListener(barraControlador_2);
	this.add(jbtnTrabajador);
    }
    
    
    
    
}
