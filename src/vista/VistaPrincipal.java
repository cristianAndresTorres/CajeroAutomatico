/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import javax.accessibility.AccessibleContext;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import modelo.Cajero;
import vistaComponentesDisegno.ObjDecoradorServicio;
import vistaComponentesDisegno.ObjGraficosServicio;
import vistaControlador.VistaControlador;

/**
 *
 * @author 57301
 */
public class VistaPrincipal extends JFrame{
    //Permite crear los componentes graficos
    ObjGraficosServicio objetoGrafico;
    ObjDecoradorServicio objDer;
    
    private JPanel jpSuperior;
    private JPanel jpInferior_Dinero;
    private JPanel jpInferior_Teclado;
    private JPanel jpLateralIz_Recibo;
    private JPanel jpLateralIz_menu;
    private JPanel jpLateralDer_menu;
    private JPanel jpLateralDer_tarjeta;
    private JPanel jpCENTRAL;
    
    //objetos de el panel pricipal
    private JLabel tex =  new JLabel();
    private JPasswordField clav= new JPasswordField();
    private JTextField entrada= new JTextField();
        
    private Cajero cj;
    
    private VistaControlador vistaControlador;
    
    //Constructor
    public VistaPrincipal(VistaControlador vistaControlador, Cajero cj){
        
        this.cj=cj;
        cj.setVen(this);
        
        
        this.vistaControlador = vistaControlador;
        
        //Dimensiones de la pantalla
        this.setSize(1200,650);
        this.setLocationRelativeTo(this);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setLayout(null);
        this.setVisible(true);
        //Objetos decoradores        
        this.objetoGrafico = ObjGraficosServicio.getServicioObjeto();
        this.objDer = ObjDecoradorServicio.obtenerServicio();
        
        this.asignarPaneles();
        this.agregarPaneles();
    }
    
    //metodos
    public void asignarPaneles(){
        jpSuperior = objetoGrafico.crearPanel(0, 0,1200, 50, objDer.getColorGrisOscuro());
        jpLateralIz_Recibo = objetoGrafico.crearPanel(0,50,200, 550, objDer.getColorVerdeClaro());
        jpLateralIz_menu = objetoGrafico.crearPanel(200, 50,100, 350, objDer.getColorRojOscuro());
        jpCENTRAL = objetoGrafico.crearPanel(300, 50,600, 350, objDer.getColorGrisClaro());
        jpLateralDer_menu = objetoGrafico.crearPanel(900,50,100,350, objDer.getColorRojClaro());
        jpLateralDer_tarjeta = objetoGrafico.crearPanel(1000,50,200,550, objDer.getColorVerdeClaro());
        jpInferior_Teclado = objetoGrafico.crearPanel(200,400,800,200, new Color(235, 222, 240));
        jpInferior_Dinero = objetoGrafico.crearPanel(0,600,1200,50, objDer.getColorGrisOscuro());//235, 222, 240
        
        
        
    }
    public void agregarPaneles(){
        
        
        this.add(jpSuperior);
        this.add(jpLateralIz_Recibo);
        this.add(jpLateralIz_menu);
        this.add(jpCENTRAL);
        this.add(jpLateralDer_menu);
        this.add(jpLateralDer_tarjeta);
        this.add(jpInferior_Teclado);
        this.add(jpInferior_Dinero);
    }

    public ObjGraficosServicio getObjetoGrafico() { return objetoGrafico;}

    public JPanel getJpSuperior() {return jpSuperior;}

    public JPanel getJpInferior_Dinero() {return jpInferior_Dinero;}

    public JPanel getJpInferior_Teclado() {return jpInferior_Teclado;}

    public JPanel getJpLateralIz_Recibo() {return jpLateralIz_Recibo;}

    public JPanel getJpLateralIz_menu() {return jpLateralIz_menu;}

    public JPanel getJpLateralDer_menu() {return jpLateralDer_menu;}

    public JPanel getJpLateralDer_tarjeta() {return jpLateralDer_tarjeta;
    }

    public JPanel getJpCENTRAL() {return jpCENTRAL;}

    public VistaControlador getVistaControlador() {return vistaControlador;}

    public ObjDecoradorServicio getObjDer() {
        return objDer;
    }

    public void setObjDer(ObjDecoradorServicio objDer) {
        this.objDer = objDer;
    }

    public JLabel getTex() {
        return tex;
    }

    public void setTex(JLabel tex) {
        this.tex = tex;
    }

    public JPasswordField getClav() {
        return clav;
    }

    public void setClav(JPasswordField clav) {
        this.clav = clav;
    }

    public Cajero getCj() {
        return cj;
    }

    public void setCj(Cajero cj) {
        this.cj = cj;
    }

    public JTextField getEntrada() {
        return entrada;
    }

    public void setEntrada(JTextField entrada) {
        this.entrada = entrada;
    }

    
    
    
}
