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
    public JButton BotonBuscar,BotonActualizar,BotonEliminar,BotonLimpiar,BotonInsertar;
    public JLabel inscripcion,nombre,propietario,edad,estado,raza;
    public String opcion="hola";
    public JComboBox razas;
    public JRadioButton si,no;
    
    
    public ventana() {
        //-----------------------------campos y nombres.....................
        inscripcion=new JLabel("N° Inscripcion:");
        inscripcion.setBounds(10, 40, widthTF, heightTF);
        textInscripcion=new JTextField();
        textInscripcion.setBounds(new Rectangle(100,40,widthTF,heightTF));
        
        nombre=new JLabel("Nombre:");
        nombre.setBounds(10, 80, widthTF, heightTF);
        textNombre=new JTextField();
        textNombre.setBounds(new Rectangle(100,80,150,heightTF));
        
        propietario=new JLabel("Propietario:");
        propietario.setBounds(300, 80, widthTF, heightTF);
        textpropietario=new JTextField();
        textpropietario.setBounds(new Rectangle(400,80,widthTF,heightTF));
        
        edad=new JLabel("Edad:");
        edad.setBounds(10, 120, widthTF, heightTF);
        textEdad=new JTextField();
        textEdad.setBounds(new Rectangle(100,120,60,heightTF));
        
        estado=new JLabel("Estado:");
        estado.setBounds(10, 200, widthTF, heightTF);
        si=new JRadioButton("si",true);
        si.setBounds(new Rectangle(100,200,50,heightTF));
        no=new JRadioButton("no");
        no.setBounds(new Rectangle(170,200,50,heightTF));
        
        raza=new JLabel("Razas:");
        raza.setBounds(10, 160, widthTF, heightTF);
        razas=new JComboBox();
        razas.setBounds(100, 160, 120, 30);
        razas.addItem("-------------");
        razas.addItem("Pitbull");
        razas.addItem("Pastor Aleman");
        razas.addItem("Gran Danes");
        razas.addItem("Dalmata");
        razas.addItem("Rottweiler");
        //------------------------botones----------------------------------------
        
        BotonBuscar=new JButton("buscar");
        BotonBuscar.setBounds(new Rectangle(300,40,widthBoton,heightBoton));
        
        BotonInsertar=new JButton("Insertar");
        BotonInsertar.setBounds(new Rectangle(10,230,widthBoton,heightBoton));
        
        BotonActualizar=new JButton("Actualizar");
        BotonActualizar.setBounds(new Rectangle(100,230,120,heightBoton));
        
        BotonLimpiar=new JButton("Limpiar");
        BotonLimpiar.setBounds(new Rectangle(230,230,widthBoton,heightBoton));
        
        BotonEliminar=new JButton("Eliminar");
        BotonEliminar.setBounds(new Rectangle(320,230,widthBoton,heightBoton));
        
        textInscripcion.setEditable(true);
        textNombre.setEditable(true);
        textpropietario.setEditable(true);
        
        
        BotonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //textNombre.setText();
                //numero.setText("inscripcion");
            }   
        });
        add(inscripcion);
        add(nombre);
        add(propietario);
        add(edad);
        add(raza);
        add(estado);
        add(razas);
        add(si);
        add(no);
        add(textInscripcion);
        add(BotonBuscar);
        add(BotonInsertar);
        add(BotonActualizar);
        add(BotonLimpiar);
        add(BotonEliminar);
        add(textNombre);
        add(textpropietario);
        add(textEdad);
        
        setLayout(null); 
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }
    
}
