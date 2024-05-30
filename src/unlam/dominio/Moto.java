package unlam.dominio;

public class Moto extends Vehiculo {
	
	private static final int NO_PAGA_PATENTE = 20;
	private static final Double CONSUMO_KILOMETRO_MOTO= 5.0;
	
	public Moto(String color, String modelo, String patente, Integer anio, Double kilometros,
			Double precio,Integer capacidadTanque, Motor motor, Integer aniosDeUso) {
		super(color, modelo, patente, anio, kilometros, precio, capacidadTanque, motor, aniosDeUso);
	}

	

	@Override
	public Double calcularAutonomiaDeVehiculo() {
		return this.getCapacidadTanque() / CONSUMO_KILOMETRO_MOTO;
	}



	@Override
	public Integer calcularEstadoEnPorcentajeDelVehiculo() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean calcularSiPagaPatente() {
		boolean paga = false;
		if (this.getAniosDeUso()>= NO_PAGA_PATENTE) {
			paga = true;
		}
		return paga;
	}

}
