import junit.framework.TestCase;
public class TiendaAlquilerTest extends TestCase
{
    private TiendaAlquiler tiendaAlquilerTest;
    private int cantidadConsolas = 3;
    
    private void setupEscenario1()
    {
        tiendaAlquilerTest = new TiendaAlquiler(cantidadConsolas);
    }
    
    private void setupEscenario2()
    {
        tiendaAlquilerTest = new TiendaAlquiler(cantidadConsolas);
        
        for (int i = 0; i < cantidadConsolas; i++)
        {
            tiendaAlquilerTest.agregarPartidaSoloConsola(10*(i+1),i);
            tiendaAlquilerTest.agregarPartidaCoopConsola(10*(i+1),i);
            tiendaAlquilerTest.agregarPartidaOnlineConsola(10*(i+1),i);
        }
    }

    public void testDarConsola()
    {
       setupEscenario1();
       for(int i = 0; i <cantidadConsolas; i++){assertNotNull("La consola "+i+" debe estar inicializada", tiendaAlquilerTest.darConsola(i));}
    }
 
    public void testAgregarPartidaSolo()
    {
        setupEscenario1();
       for (int i = 0; i <cantidadConsolas; i++)
       {
           tiendaAlquilerTest.agregarPartidaSoloConsola(100, i);
           assertEquals("La partida en solitario de la consola "+(i+1)+"no fue correctamente registrada",1, tiendaAlquilerTest.darConsola(1).darNumeroServicios());
        }
        
    }
    
    public void testAgregarPartidaCoop()
    {
        setupEscenario1();
       for (int i = 0; i <cantidadConsolas; i++)
       {
           tiendaAlquilerTest.agregarPartidaCoopConsola(10, i);
           assertEquals("La partida en cooperativo de la consola "+(i+1)+"no fue correctamente registrada",1, tiendaAlquilerTest.darConsola(i).darNumeroServicios());
        }
        
    }
    
    public void testAgregarPartidaOnline()
    {
        setupEscenario1();
       for (int i = 0; i <cantidadConsolas; i++)
       {
           tiendaAlquilerTest.agregarPartidaOnlineConsola(50, i);
           assertEquals("La partida online de la consola "+(i+1)+"no fue correctamente registrada",1, tiendaAlquilerTest.darConsola(1).darNumeroServicios());
        }
    }
    
    public void testDarTotalServicios() {setupEscenario2();assertEquals("El numero de servicios debe ser 9",9, tiendaAlquilerTest.darTotalServicios());}
    public void testDarTotalMinutos(){setupEscenario2(); assertEquals("El total de numeros debe ser 180",180,tiendaAlquilerTest.darTotalMinutos()); }
    public void testDarTotalCostoServicios(){setupEscenario2(); assertEquals("El costo total deberia ser de $10.800",10800,tiendaAlquilerTest.darTotalCostoServicios(), 0.001);}
    public void testDarCostoPromedio(){setupEscenario2(); assertEquals("El costo promedio deberia ser $60",60,tiendaAlquilerTest.darCostoPromedioMinuto(), 0.001); }

    public void testReiniciar()
    {
        setupEscenario2(); tiendaAlquilerTest.reiniciar();
        assertEquals("El total de servicios deberia ser nulo",0, tiendaAlquilerTest.darTotalServicios());
        assertEquals("El total de minutos deberia ser nulo",0, tiendaAlquilerTest.darTotalMinutos());
        assertEquals("El costo total de servicios deberia ser nulo",0, tiendaAlquilerTest.darTotalCostoServicios(), 0.01);
    }
}
