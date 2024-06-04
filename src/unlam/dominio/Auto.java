package unlam.dominio;

public class Auto extends Vehiculo {
	private static final int NO_PAGA_PATENTE = 25;
	private static final Double CONSUMO_KILOMETRO_AUTO = 8.0;
	private Integer cantidadPuertas;

	public Auto(String color, String modelo, String patente, String marca, Integer anio, Double kilometros,
			Double precio, Motor motor, Integer cantidadPuertas, Integer capacidadTanque, Integer aniosDeUso) {
		super(color, modelo, patente, marca, anio, kilometros, precio, capacidadTanque, motor, aniosDeUso);
		// TODO Auto-generated constructor stub
		this.cantidadPuertas = cantidadPuertas;
	}

	@Override
	public Integer calcularEstadoEnPorcentajeDelVehiculo() throws VehiculoNoAptoParaFuncionarException {
		if (this.getKilometros() < 250000.0) {
			return 100;
		}
		if (this.getKilometros() >= 250000.0 && this.getKilometros() <= 290000.0) {
			return 80;
		}
		if (this.getKilometros() > 290000.0 && this.getKilometros() <= 340000.0) {
			return 70;
		}
		if (this.getKilometros() > 340000.0 && this.getKilometros() <= 450000.0) {
			return 60;
		}
		throw new VehiculoNoAptoParaFuncionarException();
	}

	@Override
	public boolean calcularSiPagaPatente() throws AniosIngresadosIncorrectosException {

		if (this.getAniosDeUso() > 0 && this.getAniosDeUso() >= NO_PAGA_PATENTE) {
			return true;
		}
		throw new AniosIngresadosIncorrectosException();
	}

	public Integer getCantidadPuertas() {
		return cantidadPuertas;
	}

	public void setCantidadPuertas(Integer cantidadPuertas) {
		this.cantidadPuertas = cantidadPuertas;
	}

	@Override
	public Double calcularAutonomiaDeVehiculo() throws CapacidadDeTanqueInexistenteException {
		if (getCapacidadTanque() >= 45000.0 && getCapacidadTanque() <= 65000.0) {
			return this.getCapacidadTanque() / CONSUMO_KILOMETRO_AUTO;
		}
		throw new CapacidadDeTanqueInexistenteException();
	}

}
