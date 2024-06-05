package unlam.dominio;

import java.util.Objects;

public abstract class Vehiculo {

	private String color;
	private String modelo;
	private String patente;
	private String marca;
	private Integer anio;
	private Double kilometros;
	private Double precio;
	private Integer capacidadTanque;
	private Motor motor;
	private Integer aniosDeUso;
	
	public Vehiculo(String color, String modelo, String patente, String marca, Integer anio,
			Double kilometros, Double precio, Integer capacidadTanque, Motor motor, Integer aniosDeUso) {
		super();
		this.color = color;
		this.modelo = modelo;
		this.patente = patente;
		this.marca = marca;
		this.anio = anio;
		this.kilometros = kilometros;
		this.precio = precio;
		this.capacidadTanque = capacidadTanque;
		this.motor = motor;
		this.aniosDeUso = aniosDeUso;
	}
	
	public abstract Integer calcularEstadoEnPorcentajeDelVehiculo();
	public abstract boolean calcularSiPagaPatente();
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
	
	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getAniosDeUso() {
		return aniosDeUso;
	}

	public void setAniosDeUso(Integer aniosDeUso) {
		this.aniosDeUso = aniosDeUso;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(patente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(patente, other.patente);
	}

	
}


