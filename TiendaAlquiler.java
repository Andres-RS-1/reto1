import java.util.ArrayList;
import java.io.IOException;
import java.io.FileWriter;
public class TiendaAlquiler
{
    private ArrayList<consolasVideoJuegos> consolas;
    private int cantidadconsolas;
    
    public TiendaAlquiler(int cantidadconsolas)
    {
        this.cantidadconsolas = cantidadconsolas;
        consolas = new ArrayList <>();
        for (int i=0; i < cantidadconsolas; i++)
        {
           consolasVideoJuegos consola = new consolasVideoJuegos();
           consolas.add (consola);
        }
    }
    public void agregarPartidasolo(int minutos, int numeroconsola)
    {
        consolas.get(numeroconsola).agregarPartidaSolo(minutos);
    }
    
    public void agregarPartidaCoop(int minutos, int numeroconsola)
    {
        consolas.get(numeroconsola).agregarPartidaCoop(minutos);
    }
    
    public void agregarPartidaOnline(int minutos, int numeroconsola)
    {
        consolas.get(numeroconsola).agregarPartidaOnline(minutos);
    }
    
    public void reiniciar()
    {
        for (int i=0; i < cantidadconsolas; i++)
        {
           
           consolas.get(i).reiniciar();
        }
    }
    
    public String importacion()
    {
        ArrayList<String> datos = new ArrayList<>();
        for (consolasVideoJuegos consola : consolas)
        {
            datos.add(String.format("%d,%d,%d,%d,%d",
            consola.darNumeroServicios(),
            consola.darNumeroPartidaSolo(),
            consola.darNumeroPartidaCoop(),
            consola.darNumeroPartidaOnline(),
            consola.darNumeroMinutos()));
        }
        return exportacion();
    }
    
    public String exportacion()
    {
        try
        {
            FileWriter writer = new FileWriter("data/consolas.csv");
        
            writer.append("Costo Servicios"); writer.append(",");
            writer.append("Numero Partidas Solitario"); writer.append(",");
            writer.append("Numero Partidas Coop"); writer.append(",");
            writer.append("Numero Partidas Onine"); writer.append(",");
            writer.append("Minutos"); writer.append("\n");
            for (consolasVideoJuegos consola : consolas)
            {
             writer.append(String.valueOf(consola.darNumeroServicios())); writer.append(",");
             writer.append(String.valueOf(consola.darNumeroPartidaSolo())); writer.append(",");
             writer.append(String.valueOf(consola.darNumeroPartidaCoop())); writer.append(",");
             writer.append(String.valueOf(consola.darNumeroPartidaOnline())); writer.append(",");
             writer.append(String.valueOf(consola.darNumeroMinutos())); writer.append("\n");  
            }
            writer.flush(); writer.close();
            return "Exportacion de Datos exitosa";
            
        }
        catch (IOException e) 
        {  
        e.printStackTrace();
        return "Error a exportar los datos. Asegurese que el directorio data fue creado en la carpeta del programa";
    }
    }
    
    public consolasVideoJuegos darconsolas(int numeroconsola)
    {
        return consolas.get(numeroconsola);
    }
    
    
    public int dartotalservicios() {
    int totalNumeroservicios = 0;
    for (int i = 0; i < cantidadconsolas; i++) {
        totalNumeroservicios += consolas.get(i).darNumeroServicios();
    }
    return totalNumeroservicios; 
}

public int dartotalNumeroMinutos() {
    int totalNumeroMinutos = 0;
    for (int i = 0; i < cantidadconsolas; i++) {
        totalNumeroMinutos += consolas.get(i).darNumeroMinutos();
    }
    return totalNumeroMinutos;
}

public int dartotalCostoServicios() {
    int totalCostoServicios = 0;
    for (int i = 0; i < cantidadconsolas; i++) {
        totalCostoServicios += consolas.get(i).darCostoServicios();
    }
    return totalCostoServicios;
}

    
    public double darCostoPromedioMinuto() {
    double promedioCostoMinuto = dartotalCostoServicios() / dartotalNumeroMinutos();
    return promedioCostoMinuto;
}

}
