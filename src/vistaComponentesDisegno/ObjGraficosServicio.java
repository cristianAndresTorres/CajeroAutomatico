/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaComponentesDisegno;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 57301
 */
public class ObjGraficosServicio {
    //Atributos
    private static ObjGraficosServicio servicioObjeto;
    
    //Componentes graficos
    private JPanel jpGeneral;
    private JButton jBtnGeneral;
    private JTextField jtfCajaGeneral;
    private JLabel txtGeneral;
    
    //------------------------------------------------
    //Constructor
    private ObjGraficosServicio(){
    }
    //------------------------------------------------
    //Unico punto de acceso patron singleton
    public static ObjGraficosServicio getServicioObjeto() {
        if(servicioObjeto == null) 
                servicioObjeto = new ObjGraficosServicio();
        return servicioObjeto;
    }
    
    //Permite crear un panel general
    public JPanel crearPanel(int posicionX, int posicionY, int ancho, int alto, Color colorPanel){
        jpGeneral = new JPanel();
        jpGeneral.setLocation(posicionX,posicionY);
        jpGeneral.setSize(ancho, alto);
        jpGeneral.setBackground(colorPanel);
        jpGeneral.setLayout(null);

        return jpGeneral;
    }
    
    
    public JButton crearBoton(String nombre, int posicionX, int posicionY, int ancho, int alto, Color colorLetra,
				Color colorFondo, Cursor Tipocursor, ImageIcon iconoImg) 
	{
		
            jBtnGeneral = new JButton(nombre);
            jBtnGeneral.setLocation(posicionX, posicionY);
            jBtnGeneral.setSize(ancho, alto);

            jBtnGeneral.setBackground(colorFondo);
            jBtnGeneral.setForeground(colorLetra);

            jBtnGeneral.setCursor(Tipocursor);

            jBtnGeneral.setIcon(iconoImg);
            jBtnGeneral.setFocusable(false);
            jBtnGeneral.setBorder(null);

            return jBtnGeneral;
    }
}
