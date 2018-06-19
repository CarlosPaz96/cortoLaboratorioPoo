package GUI;

import java.awt.Dimension;
import java.awt.Checkbox;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;


/**
 *
 * @author LN710Q
 */
public class ventana extends JPanel{
    public int WIDTH=700,widthTF=120,widthBoton=80;
    public int HEIGHT=300,heightTF=30,heightBoton=30;
    public JTextField textInscripcion,textNombre,textpropietario,textEdad;
    public JButton buttonBuscar,actualizar,eliminar,limpiar;
    public JLabel numero;
    public String opcion="hola";
    public JComboBox razas;
    public JRadioButton si,no;
    
    
    public ventana() {
        //numero=new JTextField();
        
        textInscripcion=new JTextField();
        textInscripcion.setBounds(new Rectangle(100,40,widthTF,heightTF));
        
        textNombre=new JTextField();
        textNombre.setBounds(new Rectangle(100,80,150,heightTF));
        
        textpropietario=new JTextField();
        textpropietario.setBounds(new Rectangle(400,80,widthTF,heightTF));
        
        textEdad=new JTextField();
        textEdad.setBounds(new Rectangle(100,120,60,heightTF));
        
        si=new JRadioButton("si",true);
        si.setBounds(new Rectangle(100,160,50,heightTF));
        no=new JRadioButton("no");
        no.setBounds(new Rectangle(170,160,50,heightTF));
        
        razas=new JComboBox();
        razas.setBounds(100, 200, 120, 30);
        razas.addItem("-------------");
        razas.addItem("Pitbull");
        razas.addItem("Pastor Aleman");
        razas.addItem("Gran Danes");
        razas.addItem("Dalmata");
        razas.addItem("Rottweiler");
        
        
        

        
        
        buttonBuscar=new JButton("buscar");
        buttonBuscar.setBounds(new Rectangle(300,40,widthBoton,heightBoton));
        
        textInscripcion.setEditable(true);
        textNombre.setEditable(true);
        textpropietario.setEditable(true);
        
        
        buttonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //textNombre.setText();
                //numero.setText("inscripcion");
            }   
        });
        add(razas);
        add(si);
        add(no);
        add(textInscripcion);
        add(buttonBuscar);
        add(textNombre);
        add(textpropietario);
        add(textEdad);
        
        setLayout(null); 
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
}
