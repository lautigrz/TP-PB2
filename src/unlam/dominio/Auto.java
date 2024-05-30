package unlam.dominio;

public class Auto extends Vehiculo{
	private static final int NO_PAGA_PATENTE = 25;
	private static final Double CONSUMO_KILOMETRO_AUTO= 8.0;
	private Integer cantidadPuertas;
	
	public Auto(String color, String modelo, String patente, Integer anio, Double kilometros,
			Double precio, Motor motor, Integer cantidadPuertas, Integer capacidadTanque, Integer aniosDeUso) {
		super(color, modelo, patente, anio, kilometros, precio, capacidadTanque, motor, aniosDeUso);
		// TODO Auto-generated constructor stub
		this.cantidadPuertas = cantidadPuertas;
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

	public Integer getCantidadPuertas() {
		return cantidadPuertas;
	}

	public void setCantidadPuertas(Integer cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	@Override
	public Double calcularAutonomiaDeVehiculo() {
		return this.getCapacidadTanque() / CONSUMO_KILOMETRO_AUTO;
	}
	
}
