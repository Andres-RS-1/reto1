import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class panelListaDesplegable extends JPanel
{
    private Integer[] listaConsolas;
    private int contidadConsolas;
    private JComboBox<Integer> listaDesplegable; 
    private JButton btnSeleccionar;
    private JLabel lblSeleccion;
    private Interfaz interfaz;

    
    public panelListaDesplegable(Interfaz LaInterfaz, int cantidadConsolas)
    {
        setLayout(new BorderLayout());
        
        listaConsolas = new Integer[cantidadConsolas];
        for (int i = 0; i <cantidadConsolas; i++) 
        {
            listaConsolas[i]= i + 1;
        }
        
        listaDesplegable = new JComboBox <>(listaConsolas);
        listaDesplegable.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(listaDesplegable, BorderLayout.NORTH);
        
        btnSeleccionar = new JButton("Seleccionar Consola");
        btnSeleccionar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSeleccionar.setPreferredSize(new Dimension(50,30));
        add(btnSeleccionar, BorderLayout.CENTER);
        
        
        lblSeleccion = new JLabel();
        lblSeleccion.setForeground( Color.BLUE.darker());
        add(lblSeleccion, BorderLayout.SOUTH);
        lblSeleccion.setText("Seleccionaste la consola: 1");
        
        btnSeleccionar.addActionListener(new ActionListener(){public void actionPerformed (ActionEvent e){LaInterfaz.generarConsola();}});
    }
    public JComboBox<Integer> darListaDesplegable()
    {
        return listaDesplegable;
    }
    public JLabel darLblSeleccion()
    {
        return lblSeleccion;
    }
}
