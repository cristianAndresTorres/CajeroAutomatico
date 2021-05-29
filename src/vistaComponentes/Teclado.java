/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaComponentes;

import java.awt.Color;
import java.awt.Image;
import javax.accessibility.AccessibleContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;
import vistaComponentesDisegno.ObjDecoradorServicio;
import vistaComponentesDisegno.ObjGraficosServicio;
import vistaControlador.TecladoControlador;

/**
 *
 * @author 57301
 */
public class Teclado extends JPanel{
    //Atributos
    private JButton tarj,jbtn_1, jbtn_2, jbtn_3, jbtn_4, jbtn_5, jbtn_6, jbtn_7, jbtn_8, 
                jbtn_9, jbtn_0, jbtn_, jbtn_mas, jbtn_Corregir, jbtn_Cancelar, jbtn_Continuar, jbtn_editar;
    private TecladoControlador tecladoControlador;
    private JTextField num_tarj;
    private ImageIcon imgCancelar,imgIngresar,imgBorrar,imgTarjeta, imgAux;
    
    
    
    //Decoradores
    ObjDecoradorServicio objDecoradorServicio;
    ObjGraficosServicio objGraficosServicio;
    
    //Constructor
    public Teclado(TecladoControlador tecladoControlador){
        //Eventos
        this.tecladoControlador = tecladoControlador;
        //Decoradores y componentes graficos
        objDecoradorServicio = ObjDecoradorServicio.obtenerServicio();
        objGraficosServicio = ObjGraficosServicio.getServicioObjeto();
        
        //Dimensiones
        //Caracteristicas de la ventana
        this.setSize(800,200);
        this.setLayout(null);
        this.setVisible(true);
        this.setBackground(new Color(213, 219, 219));
        
        this.crearBotones();
    }
    
   public void crearBotones(){
        
        
        num_tarj= new JTextField();
        this.num_tarj.setBounds(20, 25, 99, 60);
        this.add(num_tarj);
        
        inicializarImg();
        imgAux = new ImageIcon(imgTarjeta.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        
        
        tarj = objGraficosServicio.crearBoton("tarjeta", 120, 25, 160, 60, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), imgAux);
	this.tarj.addActionListener(tecladoControlador);
	this.add(tarj);
        
        jbtn_1 = objGraficosServicio.crearBoton("1", 300, 20, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_1.addActionListener(tecladoControlador);
	this.add(jbtn_1);
        jbtn_2 = objGraficosServicio.crearBoton("2", 400, 20, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_2.addActionListener(tecladoControlador);
	this.add(jbtn_2);
        jbtn_3 = objGraficosServicio.crearBoton("3", 500, 20, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_3.addActionListener(tecladoControlador);
	this.add(jbtn_3);
        
        jbtn_4 = objGraficosServicio.crearBoton("4", 300, 65, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_4.addActionListener(tecladoControlador);
	this.add(jbtn_4);
        jbtn_5 = objGraficosServicio.crearBoton("5", 400, 65, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_5.addActionListener(tecladoControlador);
	this.add(jbtn_5);
        jbtn_6 = objGraficosServicio.crearBoton("6", 500, 65, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_6.addActionListener(tecladoControlador);
	this.add(jbtn_6);
        
        jbtn_7 = objGraficosServicio.crearBoton("7", 300, 110, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_7.addActionListener(tecladoControlador);
	this.add(jbtn_7);
        jbtn_8 = objGraficosServicio.crearBoton("8", 400, 110, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_8.addActionListener(tecladoControlador);
	this.add(jbtn_8);
        jbtn_9 = objGraficosServicio.crearBoton("9", 500, 110, 99, 44, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_9.addActionListener(tecladoControlador);
	this.add(jbtn_9);
        
        jbtn_0 = objGraficosServicio.crearBoton("0", 400, 155, 99, 43, Color.black, objDecoradorServicio.getColorGrisMedio(), objDecoradorServicio.getcMano(), null);
	this.jbtn_0.addActionListener(tecladoControlador);
	this.add(jbtn_0);
        
        imgAux = new ImageIcon(imgBorrar.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        jbtn_Corregir = objGraficosServicio.crearBoton("Corregir", 620, 25, 150, 49, Color.black, new Color(244, 208, 63), objDecoradorServicio.getcMano(), imgAux);
	this.jbtn_Corregir.addActionListener(tecladoControlador);
	this.add(jbtn_Corregir);
        
        imgAux = new ImageIcon(imgCancelar.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));

        jbtn_Cancelar = objGraficosServicio.crearBoton("Cancelar", 620, 75, 150, 49, Color.black, objDecoradorServicio.getColorRojOscuro(), objDecoradorServicio.getcMano(), imgAux);
	this.jbtn_Cancelar.addActionListener(tecladoControlador);
	this.add(jbtn_Cancelar);
        
        imgAux = new ImageIcon(imgIngresar.getImage().getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING));
        
        jbtn_Continuar = objGraficosServicio.crearBoton("Continuar", 620, 125, 150, 49, Color.black, new Color(82, 190, 128), objDecoradorServicio.getcMano(), imgAux);
	this.jbtn_Continuar.addActionListener(tecladoControlador);
	this.add(jbtn_Continuar);
        
        
    }
    
    //Nuevo codigo
    public void inicializarImg(){
        imgTarjeta = new ImageIcon("src/img/tarjeta.png");
        imgCancelar = new ImageIcon("src/img/cerrar.png");
        imgIngresar = new ImageIcon("src/img/derecha.png");
        imgBorrar = new ImageIcon("src/img/ajustes.png");
    }

    public JTextField getNum_tarj() {
        return num_tarj;
    }

    public void setNum_tarj(JTextField num_tarj) {
        this.num_tarj = num_tarj;
    }

    
    
    public JButton getTarj() {
        return tarj;
    }

    public void setTarj(JButton tarj) {
        this.tarj = tarj;
    }

    public JButton getJbtn_1() {
        return jbtn_1;
    }

    public void setJbtn_1(JButton jbtn_1) {
        this.jbtn_1 = jbtn_1;
    }

    public JButton getJbtn_2() {
        return jbtn_2;
    }

    public void setJbtn_2(JButton jbtn_2) {
        this.jbtn_2 = jbtn_2;
    }

    public JButton getJbtn_3() {
        return jbtn_3;
    }

    public void setJbtn_3(JButton jbtn_3) {
        this.jbtn_3 = jbtn_3;
    }

    public JButton getJbtn_4() {
        return jbtn_4;
    }

    public void setJbtn_4(JButton jbtn_4) {
        this.jbtn_4 = jbtn_4;
    }

    public JButton getJbtn_5() {
        return jbtn_5;
    }

    public void setJbtn_5(JButton jbtn_5) {
        this.jbtn_5 = jbtn_5;
    }

    public JButton getJbtn_6() {
        return jbtn_6;
    }

    public void setJbtn_6(JButton jbtn_6) {
        this.jbtn_6 = jbtn_6;
    }

    public JButton getJbtn_7() {
        return jbtn_7;
    }

    public void setJbtn_7(JButton jbtn_7) {
        this.jbtn_7 = jbtn_7;
    }

    public JButton getJbtn_8() {
        return jbtn_8;
    }

    public void setJbtn_8(JButton jbtn_8) {
        this.jbtn_8 = jbtn_8;
    }

    public JButton getJbtn_9() {
        return jbtn_9;
    }

    public void setJbtn_9(JButton jbtn_9) {
        this.jbtn_9 = jbtn_9;
    }

    public JButton getJbtn_0() {
        return jbtn_0;
    }

    public void setJbtn_0(JButton jbtn_0) {
        this.jbtn_0 = jbtn_0;
    }

    public JButton getJbtn_() {
        return jbtn_;
    }

    public void setJbtn_(JButton jbtn_) {
        this.jbtn_ = jbtn_;
    }

    public JButton getJbtn_mas() {
        return jbtn_mas;
    }

    public void setJbtn_mas(JButton jbtn_mas) {
        this.jbtn_mas = jbtn_mas;
    }

    public JButton getJbtn_Corregir() {
        return jbtn_Corregir;
    }

    public void setJbtn_Corregir(JButton jbtn_Corregir) {
        this.jbtn_Corregir = jbtn_Corregir;
    }

    public JButton getJbtn_Cancelar() {
        return jbtn_Cancelar;
    }

    public void setJbtn_Cancelar(JButton jbtn_Cancelar) {
        this.jbtn_Cancelar = jbtn_Cancelar;
    }

    public JButton getJbtn_Continuar() {
        return jbtn_Continuar;
    }

    public void setJbtn_Continuar(JButton jbtn_Continuar) {
        this.jbtn_Continuar = jbtn_Continuar;
    }

    public JButton getJbtn_editar() {
        return jbtn_editar;
    }

    public void setJbtn_editar(JButton jbtn_editar) {
        this.jbtn_editar = jbtn_editar;
    }

    public TecladoControlador getTecladoControlador() {
        return tecladoControlador;
    }

    public void setTecladoControlador(TecladoControlador tecladoControlador) {
        this.tecladoControlador = tecladoControlador;
    }

    public ObjDecoradorServicio getObjDecoradorServicio() {
        return objDecoradorServicio;
    }

    public void setObjDecoradorServicio(ObjDecoradorServicio objDecoradorServicio) {
        this.objDecoradorServicio = objDecoradorServicio;
    }

    public ObjGraficosServicio getObjGraficosServicio() {
        return objGraficosServicio;
    }

    public void setObjGraficosServicio(ObjGraficosServicio objGraficosServicio) {
        this.objGraficosServicio = objGraficosServicio;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
    
    
    
    
    
    
    
    
}
