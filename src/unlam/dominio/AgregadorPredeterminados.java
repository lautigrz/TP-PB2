package unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class AgregadorPredeterminados {

	Set<Vehiculo> vehiculos;
	List<Vehiculos_Duenios> listaDuenios;

	public AgregadorPredeterminados() {
		super();
		this.vehiculos = new HashSet<>();
		this.listaDuenios = new ArrayList<>();
	}

	public Set<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public List<Vehiculos_Duenios> getListaDuenios() {
		return listaDuenios;
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

	private Dueño crearDueño(String nombre, String apellido, Integer edad, Integer dni, boolean estadoAuto,
			LocalDate desde, LocalDate hasta) {

		return new Dueño(nombre, apellido, edad, dni, estadoAuto, desde, hasta);
	}

	private Motor motoresPredeterminadosDeAutos() {
		List<Motor> motor = new ArrayList<>();
		Motor motor1 = crearMotor(8, 2.5, 1786, TipoCombustible.NAFTA, tipoCajaDeCambios.MANUAL);
		Motor motor2 = crearMotor(4, 1.2, 1056, TipoCombustible.GNC, tipoCajaDeCambios.MANUAL);
		Motor motor3 = crearMotor(6, 2.5, 1346, TipoCombustible.DIESEL, tipoCajaDeCambios.AUTOMATIC0);
		Motor motor4 = crearMotor(4, 2.0, 1586, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Motor motor5 = crearMotor(4, 1.4, 1816, TipoCombustible.GNC, tipoCajaDeCambios.MANUAL);
		Motor motor6 = crearMotor(12, 3.0, 1116, TipoCombustible.NAFTA, tipoCajaDeCambios.AUTOMATIC0);

		motor.add(motor1);
		motor.add(motor2);
		motor.add(motor3);
		motor.add(motor4);
		motor.add(motor5);
		motor.add(motor6);

		Random random = new Random();

		Integer num = random.nextInt(motor.size());

		return motor.get(num);
	}

	private Motor motoresPredeterminadosDeMotos() {
		List<Motor> motor = new ArrayList<>();
		Motor motor1 = crearMotor(2, 1.8, 1786, TipoCombustible.NAFTA, tipoCajaDeCambios.MANUAL);
		Motor motor2 = crearMotor(2, 1.2, 1056, TipoCombustible.NAFTA, tipoCajaDeCambios.MANUAL);
		Motor motor3 = crearMotor(4, 1.5, 1346, TipoCombustible.DIESEL, tipoCajaDeCambios.AUTOMATIC0);
		Motor motor4 = crearMotor(2, 1.6, 1586, TipoCombustible.DIESEL, tipoCajaDeCambios.MANUAL);
		Motor motor5 = crearMotor(4, 1.4, 1816, TipoCombustible.NAFTA, tipoCajaDeCambios.MANUAL);
		Motor motor6 = crearMotor(3, 1.0, 1116, TipoCombustible.NAFTA, tipoCajaDeCambios.AUTOMATIC0);

		motor.add(motor1);
		motor.add(motor2);
		motor.add(motor3);
		motor.add(motor4);
		motor.add(motor5);
		motor.add(motor6);

		Random random = new Random();

		Integer num = random.nextInt(motor.size());

		return motor.get(num);
	}

	private List<Dueño> dueñosPredeterminados() {

		List<Dueño> dueños = new ArrayList<>();

		Dueño deuño1 = crearDueño("Lionel", "Messi", 35, 25456987, false, LocalDate.of(2020, 5, 10),
				LocalDate.of(2021, 8, 23));
		Dueño deuño2 = crearDueño("Neymar", "Junior", 35, 2597987, false, LocalDate.of(2021, 10, 20),
				LocalDate.of(2023, 5, 10));
		Dueño deuño3 = crearDueño("Tony", "Stark", 35, 35152933, false, LocalDate.of(2001, 9, 20),
				LocalDate.of(2012, 5, 10));
		Dueño deuño4 = crearDueño("Steve", "Rogers", 27, 75116937, false, LocalDate.of(2000, 9, 10),
				LocalDate.of(2005, 9, 20));
		Dueño deuño5 = crearDueño("Natasha", "Romanoff", 25, 15487884, false, LocalDate.of(2020, 5, 10),
				LocalDate.of(2021, 9, 10));
		Dueño deuño6 = crearDueño("Sebastian", "imoff", 29, 21400988, false, LocalDate.of(2017, 5, 10),
				LocalDate.of(2020, 5, 10));
		Dueño deuño7 = crearDueño("Selene", "Octov", 27, 20609121, false, LocalDate.of(2021, 6, 3),
				LocalDate.of(2022, 6, 10));
		Dueño deuño8 = crearDueño("Hermioni", "Grange", 38, 50456987, false, LocalDate.of(2020, 5, 10),
				LocalDate.of(2021, 6, 3));
		Dueño deuño9 = crearDueño("Harry", "Potter", 45, 95456987, false, LocalDate.of(2016, 5, 10),
				LocalDate.of(2018, 5, 10));
		Dueño deuño10 = crearDueño("Peter", "Parker", 65, 45346987, false, LocalDate.of(2015, 5, 12),
				LocalDate.of(2016, 5, 10));

		dueños.add(deuño1);
		dueños.add(deuño2);
		dueños.add(deuño3);
		dueños.add(deuño4);
		dueños.add(deuño5);
		dueños.add(deuño6);
		dueños.add(deuño7);
		dueños.add(deuño8);
		dueños.add(deuño9);
		dueños.add(deuño10);

		return dueños;
	}

	public void vehiculosPredeterminadosEnLaLista() {

		// Autos

		Vehiculo auto1 = ingresarAutoEnLaConcesionaria("Rojo", "Raptor", "ABC123", "Ford", 2020, 50000.0, 15000.0,
				motoresPredeterminadosDeAutos(), 4, 60, 2);
		Vehiculo auto2 = ingresarAutoEnLaConcesionaria("Azul", "Focus", "AEF156", "Ford", 2000, 17000.0, 20000.0,
				motoresPredeterminadosDeAutos(), 5, 70, 3);
		Vehiculo auto3 = ingresarAutoEnLaConcesionaria("Verde", "Fiesta", "ARF826", "Ford", 2005, 162000.0, 25000.0,
				motoresPredeterminadosDeAutos(), 5, 70, 3);
		Vehiculo auto4 = ingresarAutoEnLaConcesionaria("Negro", "Focus", "AFG992", "Ford", 2008, 125000.0, 30000.0,
				motoresPredeterminadosDeAutos(), 5, 70, 3);
		Vehiculo auto5 = ingresarAutoEnLaConcesionaria("Blanco", "Focus", "AAF056", "Ford", 1996, 270000.0, 10000.0,
				motoresPredeterminadosDeAutos(), 5, 70, 3);

		// Motos

		Vehiculo auto6 = ingresarMotoEnLaConcesionaria("Azul", "Estandar", "CBC123", "Yamaha", 2020, 50000.0, 15000.0,
				20, motoresPredeterminadosDeMotos(), 4);
		Vehiculo auto7 = ingresarMotoEnLaConcesionaria("Azul", "Estandar", "CEF156", "Suzuki", 2018, 17000.0, 20000.0,
				20, motoresPredeterminadosDeMotos(), 5);
		Vehiculo auto8 = ingresarMotoEnLaConcesionaria("Naranja", "Deportiva", "CRF826", "Kawasaki", 2015, 162000.0,
				25000.0, 20, motoresPredeterminadosDeMotos(), 5);
		Vehiculo auto9 = ingresarMotoEnLaConcesionaria("Negro", "Deportiva", "CFG992", "Ducati", 2018, 25000.0, 30000.0,
				20, motoresPredeterminadosDeMotos(), 5);
		Vehiculo auto10 = ingresarMotoEnLaConcesionaria("Blanco", "Deportiva", "CAF056", "BMW", 2021, 55000.0, 10000.0,
				20, motoresPredeterminadosDeMotos(), 5);

		agregarVehiculosParaLaVenta(auto1);
		agregarVehiculosParaLaVenta(auto2);
		agregarVehiculosParaLaVenta(auto3);
		agregarVehiculosParaLaVenta(auto4);
		agregarVehiculosParaLaVenta(auto5);
		agregarVehiculosParaLaVenta(auto6);
		agregarVehiculosParaLaVenta(auto7);
		agregarVehiculosParaLaVenta(auto8);
		agregarVehiculosParaLaVenta(auto9);
		agregarVehiculosParaLaVenta(auto10);

		// Vehiculos con sus respectivos anteriores dueños
		List<Dueño> dueños = new ArrayList<>(dueñosPredeterminados());
		
		vehiculos_dueño(auto1, dueños.get(0));
		vehiculos_dueño(auto1, dueños.get(1));
		vehiculos_dueño(auto2, dueños.get(3));
		vehiculos_dueño(auto2, dueños.get(3));
	}

	private void agregarVehiculosParaLaVenta(Vehiculo vehiculo) {

		this.vehiculos.add(vehiculo);
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
	
	
}
