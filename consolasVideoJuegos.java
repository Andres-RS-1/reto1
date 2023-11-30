public class consolasVideoJuegos
{
    private int NumeroPartidaSolo, NumeroPartidaCoop, NumeroPartidaOnline, numeroMinutos;
    private double CostoServicios, CostoPorMinutoSolo, CostoPorMinutoCoop, CostoPorMinutoOnline;
    
    public consolasVideoJuegos()
    {
        NumeroPartidaSolo = 0; NumeroPartidaCoop = 0; NumeroPartidaOnline = 0; numeroMinutos = 0; CostoServicios = 0;
        CostoPorMinutoSolo = 30; CostoPorMinutoCoop = 50; CostoPorMinutoOnline = 100;
    }

    public void reiniciar()
    {
        NumeroPartidaSolo = 0; NumeroPartidaCoop = 0; NumeroPartidaOnline = 0; numeroMinutos = 0; CostoServicios = 0;
    }
    
    public double darCostoServicios()
    {
        return CostoServicios;
    }
    
    public int darNumeroPartidaSolo()
    {
        return NumeroPartidaSolo;
    }
    
    public int darNumeroPartidaCoop()
    {
        return NumeroPartidaCoop;
    }
    
    public int darNumeroPartidaOnline()
    {
        return NumeroPartidaOnline;
    }
    
    public int darNumeroServicios()
    {
        return NumeroPartidaSolo+NumeroPartidaCoop+NumeroPartidaOnline;
    }
    
    public int darNumeroMinutos()
    {
        return numeroMinutos;
    }
    
    public void agregarPartidaSolo(int minutos)
    {
        NumeroPartidaSolo = NumeroPartidaSolo + 1;
        numeroMinutos = numeroMinutos + minutos;
        CostoServicios = CostoServicios + (minutos * CostoPorMinutoSolo);
    }
    
    public void agregarPartidaCoop(int minutos)
    {
        NumeroPartidaSolo = NumeroPartidaCoop + 1;
        numeroMinutos = numeroMinutos + minutos;
        CostoServicios = CostoServicios + (minutos * CostoPorMinutoCoop);
    }
    
    public void agregarPartidaOnline(int minutos)
    {
        NumeroPartidaSolo = NumeroPartidaOnline + 1;
        numeroMinutos = numeroMinutos + minutos;
        CostoServicios = CostoServicios + (minutos * CostoPorMinutoOnline);
    }
}
