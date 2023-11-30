import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.border.TitledBorder;
public class PanelEstadisticas extends JPanel
{
    private JLabel etiquetaCosto, etiquetaNumeroServicios, etiquetaMinutos, etiquetaCostoPromedio;
    public PanelEstadisticas()
    {
        setBorder(new TitledBorder("Totales"));
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(1000, 220));
        
        etiquetaCosto = new JLabel(formatearValor(0));
        etiquetaCosto.setForeground(Color.RED.darker());
        etiquetaCosto.setFont(new Font("Tahoma", Font.BOLD,60));
        
        etiquetaNumeroServicios = new JLabel("Servicios Totales: 0");
        etiquetaNumeroServicios.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        etiquetaMinutos = new JLabel("Minutos Totales: 0");
        etiquetaMinutos.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        etiquetaCostoPromedio = new JLabel ("Media costo/minuto: 0");
        etiquetaCostoPromedio.setFont(new Font("Tahoma", Font.BOLD, 20));
        
        GridBagConstraints posicion = new GridBagConstraints(2, 2, 1, 15, 1, 15, GridBagConstraints.CENTER);
        add(etiquetaCosto, posicion);
        
        posicion = new GridBagConstraints(2, 17, 1, 1, 1, 1, GridBagConstraints.CENTER);
        add(etiquetaNumeroServicios, posicion);
        
        posicion = new GridBagConstraints(2, 18, 1, 1, 1, 1, GridBagConstraints.CENTER);
        add(etiquetaMinutos, posicion);
        
        posicion = new GridBagConstraints(2, 19, 1, 1, 1, 1, GridBagConstraints.CENTER);
        add(etiquetaCostoPromedio,  posicion);
    }

    public void actualizar (TiendaAlquiler tiendaAlquiler)
    {
            {
        etiquetaCosto.setText(formatearValor(tiendaAlquiler.darTotalCostoServicios()));
        etiquetaNumeroServicios.setText("Servicios Totales: " + formatearValorEntero(tiendaAlquiler.darTotalNumeroServicios()));
        etiquetaMinutos.setText("Minutos Totales: " + formatearValorEntero(tiendaAlquiler.darTotalMinutos()));
        double costoPromedioMinuto = tiendaAlquiler.darCostoPromedioMinuto();
        if (!Double.isNaN(costoPromedioMinuto)) {
            etiquetaCostoPromedio.setText("Media costo/minuto: " + formatearValor(costoPromedioMinuto));
        } else {
            etiquetaCostoPromedio.setText("Media costo/minuto: ***");
        }
    }
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
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();
        df.applyPattern("###,###");
        df.setMinimumFractionDigits(0);
        return df.format(valor);
    }
}
