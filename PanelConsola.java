import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
public class PanelConsola extends JPanel
{
    private Interfaz interfaz;
    private int consola;
    private JButton btnAgregar;
    private JLabel etiquetaImagen, etiquetaCosto, etiquetaMinutos, etiquetaNumeroPartidaSolo, etiquetaNumeroPartidaCoop, etiquetaNumeroPartidaOnline;

    public PanelConsola(Interfaz LaInterfaz, int LaConsola)
    {
        consola = LaConsola + 1;
        setBorder(new TitledBorder("Consola#" + consola));
        setLayout( new GridBagLayout());
        setPreferredSize( new Dimension(260,220));
        
        etiquetaCosto = new JLabel(formatearValor(0));
        etiquetaCosto.setForeground(Color.GREEN.darker());
        etiquetaCosto.setFont(new Font("Tahoma", Font.BOLD, 30));
        
        etiquetaNumeroPartidaSolo = new JLabel("Partidas Solo: 0");
        etiquetaNumeroPartidaSolo.setFont(new Font("Tahoma", Font.BOLD,15));
        etiquetaNumeroPartidaCoop = new JLabel("Partidas Coop: 0");
        etiquetaNumeroPartidaCoop.setFont(new Font("Tahoma", Font.BOLD,15));
        etiquetaNumeroPartidaOnline = new JLabel("Partidas Online: 0");
        etiquetaNumeroPartidaOnline.setFont(new Font("Tahoma", Font.BOLD,15));
        
        etiquetaMinutos = new JLabel("Tiempo Total (min): 0");
        etiquetaMinutos.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        btnAgregar = new JButton("Agregar Servicio");
        btnAgregar.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAgregar.setPreferredSize(new Dimension(150, 25));
        btnAgregar.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){LaInterfaz.agregarServicio(consola);}});

        
        GridBagConstraints posicion = new GridBagConstraints(2, 0, 4, 2, 0, 0, GridBagConstraints.CENTER );
        add(etiquetaCosto, posicion);
        
        posicion = new GridBagConstraints( 0, 2, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        add( etiquetaNumeroPartidaSolo, posicion);
        posicion = new GridBagConstraints( 0, 4, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        add( etiquetaNumeroPartidaCoop, posicion);
        posicion = new GridBagConstraints( 0, 6, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        add( etiquetaNumeroPartidaOnline, posicion);
        
        posicion = new GridBagConstraints( 0, 8, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        add( etiquetaMinutos, posicion);
        
        posicion = new GridBagConstraints( 0, 10, 6, 2, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.CENTER);
        add( btnAgregar, posicion);
    }

    public void actualizar(consolasVideoJuegos consola)
    {
        etiquetaCosto.setText(formatearValor(consola.darCostoServicios()));
        etiquetaNumeroPartidaSolo.setText("Partidas Solo: " +formatearValorEntero(consola.darNumeroPartidaSolo));
        etiquetaNumeroPartidaCoop.setText("Partidas Coop: " +formatearValorEntero(consola.darNumeroPartidaCoop));
        etiquetaNumeroPartidaOnline.setText("Partidas Online: " +formatearValorEntero(consola.darNumeroPartidaOnline));
        
        etiquetaMinutos.setText("Tiempo Total (min): "+ formatearValorEntero(consola.darNumeroMinutos));
    }
    
    private String formatearValor(double valor)
    {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("$ ###,###.##");
        df.setMinimumFractionDigits(2);
        return df.format(valor);
    }
    private String formatearValorEntero(int valor)
    {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern("###,###.");
        df.setMinimumFractionDigits(0);
        return df.format(valor);
    }
}
