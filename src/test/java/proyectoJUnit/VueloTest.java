package proyectoJUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VueloTest {
	
	Vuelo vuelo;

	@Before
	public void setUp() throws Exception {
		vuelo = new Vuelo("Z69", "Santiago", "Tailandia", 100, 100);
	}

	@Test
	public void testGetId() {
        Assert.assertTrue(vuelo.getId().equals("Z69"));
	}

	@Test
	public void testGetOrigen() {
        Assert.assertTrue(vuelo.getOrigen().equals("Santiago"));	
	}

	@Test
	public void testGetDestino() {
        Assert.assertTrue(vuelo.getDestino().equals("Tailandia"));	
	}

	@Test
	public void testGetAsientos() {
        Assert.assertTrue(vuelo.getAsientos() == 100);
	}

	@Test
	public void testGetAsientosDisponibles() {
        Assert.assertTrue(vuelo.getAsientosDisponibles() == 100);	
	}

	@Test
	public void testSetAsientosDisponibles() {
        vuelo.setAsientosDisponibles(50);
        Assert.assertTrue(vuelo.getAsientosDisponibles() == 50);
	}

	@Test
	public void testMostrar() {
        vuelo.mostrar();
	}

	@Test
	public void testMostrarAsientos() {
        vuelo.mostrarAsientos();
	}

	@Test
	public void testReservarAsiento() {
        Assert.assertTrue(vuelo.reservarAsiento(50));
        Assert.assertTrue(vuelo.getAsientosDisponibles() == 50);
	}

	@Test
	public void testCancelarReserva() {
        vuelo.reservarAsiento(50);
        Assert.assertTrue(vuelo.getAsientosDisponibles() == 50);
        vuelo.cancelarReserva(50);
        Assert.assertTrue(vuelo.getAsientosDisponibles() == 100);
	}

}
