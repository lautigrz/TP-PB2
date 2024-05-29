package unlam.dominio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class testConcesionaria {

	@Test
	public void queSePuedanAgregarVehiculoALaListaDeVehiculosDeLaConcesionaria() throws VehiculoInexistenteException {
		Concesionaria conce = new Concesionaria("Radiador Springs");
		Motor motor = new Motor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo motoUno = new Moto("Rojo", "a", "b", 2003, 2, 0.0, 12000.0, 110, motor);

		Boolean obtenido = conce.agregarVehiculosParaLaVenta(motoUno);

		assertEquals(true, obtenido);

	}
	
	@Test(expected = VehiculoInexistenteException.class)
	public void queNoSePuedanAgregarVehiculoALaListaDeVehiculosDeLaConcesionariaYSalteElException()
			throws VehiculoInexistenteException {
		Concesionaria conce = new Concesionaria("Radiador Springs");
		Vehiculo motoUno = null;

		Boolean obtenido = conce.agregarVehiculosParaLaVenta(motoUno);

	}

	@Test
	public void queSePuedaAgregarEmpleadoALaConcesionaria() throws EmpleadoInexistenteException {
		Concesionaria conce = new Concesionaria("Radiador Springs");
		Persona nuevoEmpleado = new Empleado("Jonathan", "Rugna", 21, 123456789, 0.0);

		Boolean obtenido = conce.agregarEmpleadosAlaConcesionaria((Empleado) nuevoEmpleado);

		assertEquals(true, obtenido);
	}

	

	@Test(expected = EmpleadoInexistenteException.class)
	public void queNoSePuedaAgregarEmpleadoALaConcesionariaYSalteElException() throws EmpleadoInexistenteException {
		Concesionaria conce = new Concesionaria("Radiador Springs");
		Persona nuevoEmpleado = null;

		Boolean obtenido = conce.agregarEmpleadosAlaConcesionaria((Empleado) nuevoEmpleado);

	}

}
