package unlam.dominio;

public class Moto extends Vehiculo {
	
	public Moto(String color, String modelo, String patente, Integer anio, Integer cantidadRuedas, Double kilometros,
			Double precio,Integer capacidadTanque, Motor motor) {
		super(color, modelo, patente, anio, kilometros, precio, capacidadTanque, motor);
	}

	

	@Override
	public Double calcularAutonomiaDeVehiculo() {
		// TODO Auto-generated method stub
		return null;
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

}
