import javax.swing.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class PanelInferior extends JPanel implements ActionListener
{
    private static final String REINICIAR = "REINICIAR", IMPORTAR = "IMPORTAR", EXPORTAR = "EXPORTAR";
    private Interfaz interfaz;
    private JButton btnReiniciar, btnImportar, btnExportar;

    public PanelInferior()
    {
        interfaz = interfaz;
        setBorder ( new TitledBorder("Opciones" ));setLayout( new GridLayout( 1, 3 ) );
        btnReiniciar = new JButton( "Reiniciar" ); btnReiniciar.setActionCommand( REINICIAR );
        btnReiniciar.addActionListener( this ); add( btnReiniciar );
        btnImportar = new JButton("Importar" ); btnImportar.setActionCommand (IMPORTAR );
        btnImportar.addActionListener( this ); add( btnImportar);
        btnExportar = new JButton( "Exportar" ); btnExportar.setActionCommand (EXPORTAR );
        btnExportar.addActionListener ( this ); add( btnExportar );
    }
    
    public void actionPerformed(ActionEvent e) {
    if (IMPORTAR.equals(e.getActionCommand())) {
        interfaz.importar();
    } else if (EXPORTAR.equals(e.getActionCommand())) {
        interfaz.exportar();
    } else if (REINICIAR.equals(e.getActionCommand())) {
        interfaz.reiniciar();
    }
}
}
