package unlam.dominio;

public abstract class Vehiculo {
	private String color;
	private String modelo;
	private String patente;
	private Integer anio;
	private Double kilometros;
	private Double precio;
	private Integer capacidadTanque;
	private Motor motor;
	
	public Vehiculo(String color, String modelo, String patente, Integer anio,
			Double kilometros, Double precio, Integer capacidadTanque, Motor motor) {
		super();
		this.color = color;
		this.modelo = modelo;
		this.patente = patente;
		this.anio = anio;
		this.kilometros = kilometros;
		this.precio = precio;
		this.capacidadTanque = capacidadTanque;
		this.motor = motor;
	}
	
	public abstract Integer calcularEstadoEnPorcentajeDelVehiculo();
	public abstract boolean calcularSipagaPatente();
	public abstract Double calcularAutonomiaDeVehiculo();
	

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public Double getKilometros() {
		return kilometros;
	}

	public void setKilometros(Double kilometros) {
		this.kilometros = kilometros;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	
	public Motor getMotor() {
		return motor;
	}

	public void setMotor(Motor motor) {
		this.motor = motor;
	}

	public Integer getCapacidadTanque() {
		return capacidadTanque;
	}

	public void setCapacidadTanque(Integer capacidadTanque) {
		this.capacidadTanque = capacidadTanque;
	}

	public Double calcularAutonomia() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}


