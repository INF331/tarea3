package proyectoJUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
	
	private Cliente cliente;

	@Before
	public void setUp() throws Exception {
		cliente = new Cliente("Joselito", "Rosas");
	}

	@Test
	public void testGetNombre() {
		Assert.assertTrue(cliente.getNombre().equals("Joselito"));
	}

	@Test
	public void testGetApellido() {
		Assert.assertTrue(cliente.getApellido().equals("Rosas"));
	}

}
