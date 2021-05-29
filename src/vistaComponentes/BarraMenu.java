/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaComponentes;

import static javafx.scene.paint.Color.color;
import javax.swing.JButton;
import javax.swing.JPanel;
import vistaComponentesDisegno.ObjDecoradorServicio;
import vistaComponentesDisegno.ObjGraficosServicio;
import vistaControlador.BarraMenuControlador;

/**
 *
 * @author 57301
 */
public class BarraMenu extends JPanel{
    //Crear botones
    private ObjGraficosServicio obGrafico1;
    private ObjDecoradorServicio obDecorador1;
    
    //Atributos
    private JButton jbtnRetirar, jbtnTransferir, jbtnConsulta, jbtnConsignar;
    private BarraMenuControlador barraControlador;

    
    public BarraMenu(BarraMenuControlador barraControlador){
        this.barraControlador = barraControlador;
        
        obGrafico1 = ObjGraficosServicio.getServicioObjeto();
        obDecorador1 = ObjDecoradorServicio.obtenerServicio();
        crearBotonesMenu();
        
        //Caracteristicas de la ventana
        this.setSize(100, 350);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(obDecorador1.getColorRojClaro());
   

    }
    
    //Metodos
    
    //Crear botonoes
    public void crearBotonesMenu(){
        
        jbtnConsignar = obGrafico1.crearBoton("", 5, 50, 90, 50, null, obDecorador1.getColorRojOscuro(), obDecorador1.getcMano(), null);
	this.jbtnConsignar.addActionListener(barraControlador);
	this.add(jbtnConsignar);
        
        jbtnTransferir = obGrafico1.crearBoton("", 5, 120, 90, 50, null,obDecorador1.getColorRojOscuro(), obDecorador1.getcMano(), null);
	this.jbtnTransferir.addActionListener(barraControlador);
	this.add(jbtnTransferir);
        
        jbtnConsulta = obGrafico1.crearBoton("", 5, 190, 90, 50, null, obDecorador1.getColorRojOscuro(), obDecorador1.getcMano(), null);
	this.jbtnConsulta.addActionListener(barraControlador);
	this.add(jbtnConsulta);
        
        jbtnRetirar = obGrafico1.crearBoton("", 5, 260, 90, 50, null, obDecorador1.getColorRojOscuro(), obDecorador1.getcMano(), null);
	this.jbtnRetirar.addActionListener(barraControlador);
	this.add(jbtnRetirar);
        
    }

    public ObjGraficosServicio getObGrafico1() {
        return obGrafico1;
    }

    public void setObGrafico1(ObjGraficosServicio obGrafico1) {
        this.obGrafico1 = obGrafico1;
    }

    public ObjDecoradorServicio getObDecorador1() {
        return obDecorador1;
    }

    public void setObDecorador1(ObjDecoradorServicio obDecorador1) {
        this.obDecorador1 = obDecorador1;
    }

    public JButton getJbtnTransferir() {
        return jbtnTransferir;
    }

    public void setJbtnTransferir(JButton jbtnTransferir) {
        this.jbtnTransferir = jbtnTransferir;
    }

    public JButton getJbtnConsulta() {
        return jbtnConsulta;
    }

    public void setJbtnConsulta(JButton jbtnConsulta) {
        this.jbtnConsulta = jbtnConsulta;
    }

    public JButton getJbtnConsignar() {
        return jbtnConsignar;
    }

    public void setJbtnConsignar(JButton jbtnConsignar) {
        this.jbtnConsignar = jbtnConsignar;
    }

    public BarraMenuControlador getBarraControlador() {
        return barraControlador;
    }

    public void setBarraControlador(BarraMenuControlador barraControlador) {
        this.barraControlador = barraControlador;
    }

    public JButton getJbtnRetirar() {
        return jbtnRetirar;
    }

    public void setJbtnRetirar(JButton jbtnRetirar) {
        this.jbtnRetirar = jbtnRetirar;
    }
    
    
    
    
}
