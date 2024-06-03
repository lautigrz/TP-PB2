package unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Before;

import exepciones.unlam.PreferenciasNoEncontradasException;
import exepciones.unlam.VentaException;
import exepciones.unlam.empleadosInexistentesEnConcesionaria;

public class Concesionaria implements IConcesionaria {
	private String nombre;
	Set<Vehiculo> vehiculos;
	List<Venta> venta;
	List<Vehiculos_Duenios> listaDuenios;
	Set<Empleado> empleados;

	public Concesionaria(String nombre) {
		super();
		
		this.vehiculos = new HashSet<>();
		this.listaDuenios = new ArrayList<>();
		inicializarAgregados();
		this.nombre = nombre;
		this.venta = new ArrayList<>();
		this.empleados = new HashSet<>();
	}

	private void inicializarAgregados() {
		// TODO Auto-generated method stub
		AgregadorPredeterminados agregados = new AgregadorPredeterminados();
		agregados.vehiculosPredeterminadosEnLaLista();

		vehiculos.addAll(agregados.getVehiculos());
		listaDuenios.addAll(agregados.getListaDuenios());
	}

	public String getNombre() {
		return nombre;
	}

	public boolean agregarVehiculosParaLaVenta(Vehiculo vehiculo) throws VehiculoInexistenteException {

		if (vehiculo == null) {
			throw new VehiculoInexistenteException();
		}
		return this.vehiculos.add(vehiculo);
	}

	public boolean agregarEmpleadosAlaConcesionaria(Empleado empleado) throws empleadosInexistentesEnConcesionaria {
		if (empleado == null) {
			throw new empleadosInexistentesEnConcesionaria("");
		}
		return this.empleados.add(empleado);
	}

	public List<Vehiculo> obtenerVehiculosConPreferencias(Integer preferenciaAnio, Double preferenciaKilometros)
			throws PreferenciasNoEncontradasException {

		List<Vehiculo> vehiculos = new ArrayList<>();

		for (Vehiculo v : this.vehiculos) {

			if (v.getAnio().equals(preferenciaAnio) && v.getKilometros().equals(preferenciaKilometros)) {

				vehiculos.add(v);
			}

		}

		if (vehiculos.isEmpty()) {
			throw new PreferenciasNoEncontradasException("No se encontraron vehículos con las preferencias elegidas");
		}

		return vehiculos;
	}

	@Override
	public boolean generarVenta(Vehiculo vehiculo, Dueño dueñoComprador, Double saldoPagar)
			throws empleadosInexistentesEnConcesionaria, VentaException {
		
		
		Empleado empleado = obtenerEmpleado();

		if (empleado == null) {
			new empleadosInexistentesEnConcesionaria("No existe empleado para generar venta");
		}

		for (Vehiculo v : this.vehiculos) {

			if (v.equals(vehiculo) && saldoPagar >= vehiculo.getPrecio()) {

				 procesarVenta(vehiculo,dueñoComprador, empleado);
				
				return true;
			}
		}

		return false;
	}
	
	public Vehiculo buscarVehiculoPorPatente(String patente) throws VehiculoInexistenteException {

		for (Vehiculo vehiculo : vehiculos) {
			if (vehiculo.getPatente().equals(patente)) {
				return vehiculo;
			}
		}
		throw new VehiculoInexistenteException();// agregue el exception y modifique un poco la estructura del metodo
	}

	public List<Moto> obtenerMotos() throws ConcesionariaVaciaDeMotosException {
		/*
		 * Cambie el tipo de la lista para aplicar polimorfismo y castie el vehiculo
		 * para que no haya errores
		 */

		List<Moto> motos = new ArrayList<>();
		if (this.vehiculos.size() != 0) {
			for (Vehiculo v : this.vehiculos) {

				if (v instanceof Moto) {

					motos.add((Moto) v); // Casteo
				}
			}
		}
		throw new ConcesionariaVaciaDeMotosException("");
	}

	public List<Auto> obtenerAutos() throws ConcesionariaVaciaDeAutosException {
		/*
		 * Cambie el tipo de la lista para aplicar polimorfismo y castie el vehiculo
		 * para que no haya errores
		 */

		List<Auto> autos = new ArrayList<>();
		if (this.vehiculos.size() != 0) {

			for (Vehiculo v : this.vehiculos) {

				if (v instanceof Auto) {

					autos.add((Auto) v);// Casteo
				}
			}
			return autos;
		}

		throw new ConcesionariaVaciaDeAutosException("");

	}


	public void vehiculos_dueño(Vehiculo vehiculo, Dueño dueñoComprador) {

		 boolean encontrado = false;
		    
		    for (Vehiculos_Duenios v : listaDuenios) {
		        if (v.getVehiculo().equals(vehiculo)) {
		            v.agregarDueño(dueñoComprador);
		            encontrado = true;
		            break;
		        }
		    }

		    if (!encontrado) {
		        Vehiculos_Duenios vehi = new Vehiculos_Duenios(vehiculo);
		        vehi.agregarDueño(dueñoComprador);
		        this.listaDuenios.add(vehi);
		    }

	}

	public Set<Dueño> buscarVehiculoPorPatenteYObtenerSusDueños(String patente) throws VehiculoInexistenteException {

		Vehiculo vehiculo = buscarVehiculoPorPatente(patente);

		for (Vehiculos_Duenios v : listaDuenios) {

			if (v.getVehiculo().equals(vehiculo)) {

				return v.getDueños();
			}

		}

		throw new VehiculoInexistenteException();// agregue el exception y modifique un poco la estructura del metodo
	}

	// Agregado Por Jhony metodo para mostrar la lista de vehiculos y comprobar que
	// no este vacio
	// usando exeption.

	@Override
	public Set<Vehiculo> listaVehiculosDisponiblesParaVender() throws ConcesionariaVaciaException {

		if (!this.vehiculos.isEmpty()) {
			return this.vehiculos;
		}

		throw new ConcesionariaVaciaException("Concesionaria sin Vehiculos disponibles.");
	}

	// Agregado Por Jhony metodo para mostrar la lista de autos y comprobar que no
	// este vacio usando exeption.

	@Override
	public List<Auto> listaAutosDisponiblesParaVender() throws ConcesionariaVaciaDeAutosException {

		List<Auto> listaAutos = obtenerAutos();

		if (!listaAutos.isEmpty()) {
			return listaAutos;
		}
		throw new ConcesionariaVaciaDeAutosException("Concesionaria sin Autos disponibles.");
	}

	// Agregado Por Jhony metodo para mostrar la lista de Motos y comprobar que no
	// este vacio usando exeption.

	@Override
	public List<Moto> listaMotosDisponiblesParaVender() throws ConcesionariaVaciaDeMotosException {
		List<Moto> listaMotos = obtenerMotos();

		if (!listaMotos.isEmpty()) {
			return listaMotos;
		}

		throw new ConcesionariaVaciaDeMotosException("Concesionaria sin Autos disponibles.");
	}

	public Empleado obtenerEmpleado() throws empleadosInexistentesEnConcesionaria {

		List<Empleado> empleadoParaBuscar = new ArrayList<>(this.empleados);

		if (empleadoParaBuscar.isEmpty()) {
			throw new empleadosInexistentesEnConcesionaria("No existen empleados");
		}

		Random random = new Random();
		Integer numEmpleado = random.nextInt(empleadoParaBuscar.size());

		return empleadoParaBuscar.get(numEmpleado);

	}
	
	
	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	private void procesarVenta(Vehiculo vehiculo, Dueño dueñoComprador, Empleado empleado) throws VentaException  {
		  try {
		        // Agregar la venta
		        agregarVenta(vehiculo, dueñoComprador, LocalDate.now());

		        // Asociar el vehículo con el nuevo dueño
		        vehiculos_dueño(vehiculo, dueñoComprador);

		        // Registrar el vehículo vendido por el empleado
		        empleado.agregarVehiculoVendidoPorEmpleado(vehiculo);

		        // Eliminar el vehículo del inventario
		       // eliminarVehiculoYaVendido(vehiculo);
		    } catch (Exception e) {
		        // Lanza la excepción personalizada si ocurre algún error
		        throw new VentaException("Error al procesar la venta del vehículo: " + vehiculo, e);
		    }
	}
	
	

	private void agregarVenta(Vehiculo vehiculo, Dueño dueñoComprador, LocalDate now) {

		Venta venta = new Venta(vehiculo, dueñoComprador, now);
		
		this.venta.add(venta);
	}
	
	private void eliminarVehiculoYaVendido(Vehiculo vehiculo) {
		this.vehiculos.remove(vehiculo);
	}

}
