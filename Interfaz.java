import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class Interfaz extends JFrame
{
    private TiendaAlquiler tiendaAlquiler;
    private int cantidadConsolas;
    private ArrayList<PanelConsola> panelConsolas;
    private Integer [] listaConsolas;
    private panelListaDesplegable panelListaDesplegable;
    private PanelLogo panelLogo;
    private PanelEstadisticas panelEstadisticas;
    private PanelInferior panelInferior;
    private JPanel panelContenedorConsolas;
    
    public Interfaz(int cantidadConsolas)
    {
        this.cantidadConsolas = cantidadConsolas;
        tiendaAlquiler = new TiendaAlquiler(cantidadConsolas);
        
        panelConsolas = new ArrayList<>();
        for (int i = 0; i <cantidadConsolas; i++){PanelConsola panelConsola = new PanelConsola (this, i); panelConsolas.add(panelConsola);}
    
    setTitle("Software alquiler de consolas");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().setLayout(new BorderLayout());
    
    JPanel panelTotalesLogo = new JPanel();
    panelTotalesLogo.setLayout(new BorderLayout());
    getContentPane().add(panelTotalesLogo, BorderLayout. EAST);
    
    panelEstadisticas = new PanelEstadisticas(); panelTotalesLogo.add(panelEstadisticas, BorderLayout.WEST);
    
    panelLogo = new PanelLogo(); panelTotalesLogo.add(panelLogo,BorderLayout.EAST);
    
    panelContenedorConsolas = new JPanel();
    panelContenedorConsolas.setLayout(new BorderLayout());
    getContentPane().add(panelContenedorConsolas, BorderLayout.WEST);
    
    JPanel panelVisorConsola = new JPanel();
    panelVisorConsola.setLayout(new BorderLayout());
    panelContenedorConsolas.add(panelVisorConsola, BorderLayout.NORTH);
    panelContenedorConsolas.add(panelConsolas.get(0), BorderLayout.NORTH);
    
    panelListaDesplegable = new panelListaDesplegable(this , cantidadConsolas);
    panelContenedorConsolas.add(panelListaDesplegable, BorderLayout.SOUTH);
    
    panelInferior = new PanelInferior(this); getContentPane().add(panelInferior, BorderLayout.SOUTH);
    
    pack(); setResizable(false);
    }
    
    public void exportar() {
    String resultado = tiendaAlquiler.exportacion();
    JOptionPane.showMessageDialog(this, resultado, "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void generarConsola()
    { int seleccion = (int) panelListaDesplegable.darListaDesplegable().getSelectedItem();
      panelListaDesplegable.darLblSeleccion().setText("Seleccionaste la Consola: " + seleccion);
      for (int i=0; i <cantidadConsolas; i++ ){
          panelContenedorConsolas.remove(panelConsolas.get(i));
      }
      panelContenedorConsolas.add(panelConsolas.get(seleccion-1), BorderLayout.NORTH);
      panelContenedorConsolas.repaint();
    }
    
    public void agregarServicio(int consola)
    {
       String minutos = JOptionPane.showInputDialog(this, "Numero de minutos que se alquilo la consola" + consola);
       try
       {
           if (minutos != null)
           {
               int min = Integer.parseInt(minutos);
               Object[] possibilities = {"Solo", "Coop","Online"};
               String tipo = (String) JOptionPane.showInputDialog(this, "Tipo de servicio prestado:", "Tipo", JOptionPane.QUESTION_MESSAGE, null, possibilities, "Solo");
               if (min <= 0){JOptionPane.showMessageDialog(this, "La cantidad ingresada debe ser mayor a cero", "Error", JOptionPane.ERROR_MESSAGE);return;}
               if (tipo != null)
               {if("Solo".equals(tipo)){tiendaAlquiler.agregarPartidaSoloConsola(min, consola-1);}
               else if ("Coop".equals(tipo)){tiendaAlquiler.agregarPartidaCoopConsola(min, consola-1);}
               else if ("Online".equals(tipo)){tiendaAlquiler.agregarPartidaOnlineConsola(min, consola-1);}
               actualizar(cantidadConsolas);
       }
    }
}
catch (NumberFormatException e) {JOptionPane.showMessageDialog(this, "El numero de minutos es invalido", "Error", JOptionpane.ERROR_MESSAGE);}
}

public void reiniciar() {tiendaAlquiler.reiniciar(); actualizar(this.cantidadConsolas);}

private void actualizar(int cantidadConsolas)
{
    panelEstadisticas.actualizar(tiendaAlquiler);
    for(int i = 0; i <cantidadConsolas; i++){panelConsolas.get(i).actualizar(tiendaAlquiler.darConsola(i));}
}

public void importar()
{
    String resultado = tiendaAlquiler.importacion();
    JOptionPane.showMessageDialog(this, resultado, "Alerta", JOptionPane.INFORMATION_MESSAGE);
}
}