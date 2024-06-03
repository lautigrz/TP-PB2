package unlam.dominio;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

import exepciones.unlam.VentaException;
import exepciones.unlam.empleadosInexistentesEnConcesionaria;

public class testConcesionaria {
	private static final String NOMBRE_CONCESIONARIA = "Radiador Springs";
	private Concesionaria conce;

	@Before
	public void init() {
		this.conce = new Concesionaria(NOMBRE_CONCESIONARIA);
	}

	@Test
	public void queSePuedanAgregarVehiculoMotoALaListaDeVehiculosDeLaConcesionaria()// Exception hecho
			throws VehiculoInexistenteException {
		Motor motor = crearMotor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo motoUno = ingresarMotoEnLaConcesionaria("Rojo", "a", "b", "Ford", 2003, 0.0, 12000.0, 110, motor, 10);

		Boolean obtenido = conce.agregarVehiculosParaLaVenta(motoUno);

		assertEquals(true, obtenido);

	}

	@Test
	public void queSePuedanAgregarVehiculoAutoALaListaDeVehiculosDeLaConcesionaria()// Exception hecho
			throws VehiculoInexistenteException {
		Motor motor = crearMotor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo autoUno = ingresarAutoEnLaConcesionaria("Rojo", "Up", "OGA634", "Ford", 2012, 12000.0, 20000.0, motor,
				4, 2000, 20);

		Boolean obtenido = conce.agregarVehiculosParaLaVenta(autoUno);

		assertEquals(true, obtenido);

	}

	@Test
	public void dadoQueExisteUnVehiculoEnLaConcesionariaBuscarUnVehiculoPorPatente()// Exception hecho
			throws VehiculoInexistenteException {
		Motor motor = crearMotor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo autoUno = ingresarAutoEnLaConcesionaria("Rojo", "Up", "OGA634", "Ford", 2012, 12000.0, 20000.0, motor,
				4, 2000, 20);
		this.conce.agregarVehiculosParaLaVenta(autoUno);

		String patenteBuscada = "OGA634";
		Vehiculo vehiculoObtenido = conce.buscarVehiculoPorPatente(patenteBuscada);

		assertEquals(patenteBuscada, vehiculoObtenido.getPatente());

	}

	@Test
	public void queSePuedaAgregarEmpleadoALaConcesionaria() throws empleadosInexistentesEnConcesionaria {// Exception
																											// hecho
		Persona nuevoEmpleado = new Empleado("Jonathan", "Rugna", 21, 123456789);

		Boolean obtenido = conce.agregarEmpleadosAlaConcesionaria((Empleado) nuevoEmpleado);

		assertEquals(true, obtenido);
	}

	@Test
	public void queSePuedaCalcularLaAutonomiaDeUnVehiculoAutoDeLaConcesionaria() {// Exception hecho

		Motor motor = crearMotor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo autoUno = ingresarAutoEnLaConcesionaria("Rojo", "Up", "OGA634", "Ford", 2012, 12000.0, 20000.0, motor,
				4, 45000, 20);

		Double valor = autoUno.calcularAutonomiaDeVehiculo();
		Double valorEsperado = 5625.0;

		assertEquals(valorEsperado, valor);

	}

	@Test
	public void queSePuedaCalcularLaAutonomiaDeUnVehiculoMotoDeLaConcesionaria() { // Falta exception
		Motor motor = crearMotor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo motoUno = ingresarMotoEnLaConcesionaria("Rojo", "a", "b", "Ford", 2003, 0.0, 12000.0, 110, motor, 10);
		Double valor = motoUno.calcularAutonomiaDeVehiculo();
		Double valorEsperado = 22.0;

		assertEquals(valorEsperado, valor);

	}

	@Test
	public void queSePuedaCalcularSiUnVehiculoDeLaConcesionariaPagaPatente() {// falta exception
		Motor motor = crearMotor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo motoUno = ingresarMotoEnLaConcesionaria("Rojo", "a", "b", "Ford", 2003, 0.0, 12000.0, 110, motor, 25);
		Boolean obtenido = motoUno.calcularSiPagaPatente();

		assertTrue(obtenido);

	}

	@Test(expected = VehiculoInexistenteException.class)
	public void queNoSePuedanAgregarVehiculoMotoALaListaDeVehiculosDeLaConcesionariaYSalteElException()
			throws VehiculoInexistenteException {
		Vehiculo motoUno = null;

		conce.agregarVehiculosParaLaVenta(motoUno);

	}

	@Test(expected = VehiculoInexistenteException.class)
	public void queNoSePuedanAgregarVehiculoAutoALaListaDeVehiculosDeLaConcesionariaYSalteElException()
			throws VehiculoInexistenteException {
		Auto auto = null;

		conce.agregarVehiculosParaLaVenta(auto);

	}

	@Test(expected = EmpleadoInexistenteException.class)
	public void queNoSePuedaAgregarEmpleadoALaConcesionariaYSalteElException()
			throws empleadosInexistentesEnConcesionaria {
		Persona nuevoEmpleado = null;

		conce.agregarEmpleadosAlaConcesionaria((Empleado) nuevoEmpleado);

	}

	@Test(expected = VehiculoInexistenteException.class)
	public void dadoQueNoExisteUnVehiculoEnLaConcesionariaBuscarUnVehiculoPorPatenteYSalteException()
			throws VehiculoInexistenteException {
		Motor motor = new Motor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo autoUno = ingresarAutoEnLaConcesionaria("Rojo", "Up", "OGA635", "Ford", 2012, 12000.0, 20000.0, motor,
				4, 2000, 20);
		this.conce.agregarVehiculosParaLaVenta(autoUno);

		String patenteBuscada = "OGA634";
		conce.buscarVehiculoPorPatente(patenteBuscada);

	}

	@Test(expected = CapacidadDeTanqueInexistenteException.class)
	public void queNoSePuedaCalcularLaAutonomiaDeUnVehiculoAutoDeLaConcesionaria()
			throws CapacidadDeTanqueInexistenteException {

		Motor motor = new Motor(2, 2.2, 1, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Vehiculo autoUno = ingresarAutoEnLaConcesionaria("Rojo", "Up", "OGA634", "Ford", 2012, 12000.0, 20000.0, motor,
				4, 40000, 20);

		autoUno.calcularAutonomiaDeVehiculo();

	}

	@Test
	public void obtenerUnVehiculoConDueñosPorSuPatente() {

		Set<Dueño> dueños = new TreeSet<>(conce.buscarVehiculoPorPatenteYObtenerSusDueños("ABC123"));

		assertEquals(2, dueños.size());

	}
	
	@Test
	public void queSeGenereUnaVenta() throws empleadosInexistentesEnConcesionaria, VentaException {
		Empleado empleado = new Empleado("Iron", "Man", 25, 46756987);
		conce.agregarEmpleadosAlaConcesionaria(empleado);
		Vehiculo vehiculo = conce.buscarVehiculoPorPatente("ABC123");
		Dueño dueño = crearDueño("Mauro", "Lombardo",29,47890912, true, LocalDate.now(), null);
		
		Boolean seGenero = conce.generarVenta(vehiculo, dueño, 50000.0);
		
		assertTrue(seGenero);
	}
	
	@Test
	public void alGenerarUnaVentaObenerElDueñoActual() throws empleadosInexistentesEnConcesionaria, VentaException {
		Empleado empleado = new Empleado("Iron", "Man", 25, 46756987);
		conce.agregarEmpleadosAlaConcesionaria(empleado);
		Vehiculo vehiculo = conce.buscarVehiculoPorPatente("ABC123");
		Dueño dueño = crearDueño("Mauro", "Lombardo",29,47890912, true, LocalDate.now(), null);
		conce.generarVenta(vehiculo, dueño, 50000.0);
		
		
		Set<Dueño> dueños = new TreeSet<>(conce.buscarVehiculoPorPatenteYObtenerSusDueños("ABC123"));
		
		 Dueño primerDueño = dueños.iterator().next();
	     assertEquals(dueño, primerDueño);

	}
	
	@Test
	public void alGenerarVentasObtenerElTotalDeComisonDeEmpleado() throws empleadosInexistentesEnConcesionaria, VentaException {
		Empleado empleado = new Empleado("Iron", "Man", 25, 46756987);
		conce.agregarEmpleadosAlaConcesionaria(empleado);
		Vehiculo vehiculo = conce.buscarVehiculoPorPatente("ABC123");
		Dueño dueño = crearDueño("Mauro", "Lombardo",29,47890912, true, LocalDate.now(), null);
		conce.generarVenta(vehiculo, dueño, 50000.0);
		
		vehiculo = conce.buscarVehiculoPorPatente("AEF156");
		dueño = crearDueño("Maurito", "Lombardito",32,4111232, true, LocalDate.now(), null);
		conce.generarVenta(vehiculo, dueño, 30000.0);
		
		Double comision = empleado.getComisionGanada();
		
		assertEquals(5250.0, comision, 0.1);
		
	}

	private Vehiculo ingresarAutoEnLaConcesionaria(String color, String modelo, String patente, String marca,
			Integer anio, Double kilometros, Double precio, Motor motor, Integer cantidadPuertas,
			Integer capacidadTanque, Integer aniosDeUso) {
		return new Auto(color, modelo, patente, marca, anio, kilometros, precio, motor, cantidadPuertas,
				capacidadTanque, aniosDeUso);
	}

	private Vehiculo ingresarMotoEnLaConcesionaria(String color, String modelo, String patente, String marca,
			Integer anio, Double kilometros, Double precio, Integer capacidadTanque, Motor motor, Integer aniosDeUso) {
		return new Moto(color, modelo, patente, marca, anio, kilometros, precio, capacidadTanque, motor, aniosDeUso);
	}

	private Motor crearMotor(Integer cantidadCilindros, Double cilindrada, Integer numeroMotor,
			TipoCombustible tipoCombustible, tipoCajaDeCambios cajaDeCambios) {

		return new Motor(cantidadCilindros, cilindrada, numeroMotor, tipoCombustible, cajaDeCambios);

	}

	public Dueño crearDueño(String nombre, String apellido, Integer edad, Integer dni, boolean estadoAuto,
			LocalDate desde, LocalDate hasta) {

		return new Dueño(nombre, apellido, edad, dni, estadoAuto, desde, hasta);
	}

}
