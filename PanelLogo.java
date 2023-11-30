import javax.swing.*;
import java.awt.*;

public class PanelLogo extends JPanel
{
    private JLabel etiquetaLogo;
    private ImageIcon logo;
    public PanelLogo()
    {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(260, 220));
        logo = new ImageIcon("Documetos/logo5.jpg");
        etiquetaLogo = new JLabel("");
        etiquetaLogo.setIcon(logo); add(etiquetaLogo);
    }
}
