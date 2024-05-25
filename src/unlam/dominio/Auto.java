package unlam.dominio;

public class Auto extends Vehiculo{
	
	private Integer cantidadPuertas;
	
	public Auto(String color, String modelo, String patente, Integer anio, Double kilometros,
			Double precio, Motor motor, Integer cantidadPuertas, Integer capacidadTanque) {
		super(color, modelo, patente, anio, kilometros, precio, capacidadTanque, motor);
		// TODO Auto-generated constructor stub
		this.cantidadPuertas = cantidadPuertas;
	}

	@Override
	public Integer calcularEstadoEnPorcentajeDelVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean calcularSipagaPatente() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Double calcularAutonomia() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCantidadPuertas() {
		return cantidadPuertas;
	}

	public void setCantidadPuertas(Integer cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	@Override
	public Double calcularAutonomiaDeVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
