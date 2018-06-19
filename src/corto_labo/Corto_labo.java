/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package corto_labo;

import GUI.ventana;
import javax.swing.JFrame;

/**
 *
 * @author LN710Q
 */
public class Corto_labo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame ventana=new JFrame("Inscripciones");
        ventana.setContentPane(new ventana());
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.pack();
        ventana.setVisible(true);
    }
    
}
