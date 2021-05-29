/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistaControlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Cajero;
import vistaComponentes.BarraMenuDos;

/**
 *
 * @author 57301
 */
public class BarraMenuDosControlador implements ActionListener{
    //Atributos
    private BarraMenuDos barraMenuDos;
    private Cajero cj;
    private VistaControlador vc;
    
    //-------------------------------------------------------------------
    //Constructor
    public BarraMenuDosControlador(Cajero cj,VistaControlador vc){
        barraMenuDos = new BarraMenuDos(this);
        this.cj= cj;
        this.vc=vc;
    }
    //-------------------------------------------------------------------
    
    //Metodos getters and setters
    public BarraMenuDos getBarraMenuDos(){
        return barraMenuDos;}
    
    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
}
