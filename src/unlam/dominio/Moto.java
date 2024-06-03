package unlam.dominio;

public class Moto extends Vehiculo {

	private static final int NO_PAGA_PATENTE = 20;
	private static final Double CONSUMO_KILOMETRO_MOTO = 5.0;

	public Moto(String color, String modelo, String patente, String marca, Integer anio, Double kilometros, Double precio,
			Integer capacidadTanque, Motor motor, Integer aniosDeUso) {
		super(color, modelo, patente, marca, anio, kilometros, precio, capacidadTanque, motor, aniosDeUso);
	}

	@Override
	public Double calcularAutonomiaDeVehiculo() throws CapacidadDeTanqueInexistenteException {
		if (getCapacidadTanque() >= 50.0 && getCapacidadTanque() <= 1500.0) {
			return this.getCapacidadTanque() / CONSUMO_KILOMETRO_MOTO;
		}
		throw new CapacidadDeTanqueInexistenteException();
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
	public boolean calcularSiPagaPatente() {
		boolean paga = false;
		if (this.getAniosDeUso() >= NO_PAGA_PATENTE) {
			paga = true;
		}
		return paga;
	}

}
