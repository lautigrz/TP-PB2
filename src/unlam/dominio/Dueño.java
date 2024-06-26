package unlam.dominio;

import java.time.LocalDate;

public class Dueño extends Persona implements Comparable<Dueño> {

	private boolean esPropetario;
	private Integer preferenciaAnio;
	private Integer preferenciaKilometros;
	private String preferenciaTipoDeVehiculo;
	private LocalDate desde;
	private LocalDate hasta;

	public Dueño(String nombre, String apellido, Integer edad, Integer dni, boolean estadoAuto, LocalDate desde,
			LocalDate hasta) {
		super(nombre, apellido, edad, dni);
		// TODO Auto-generated constructor stub
		this.esPropetario = estadoAuto;
		this.desde = desde;
		this.hasta = hasta;
	}

	public boolean isPropetario() {
		return esPropetario;
	}

	public void setEsPropetario(boolean estadoAuto) {
		this.esPropetario = estadoAuto;
	}

	public Integer getPreferenciaAnio() {
		return preferenciaAnio;
	}

	public void preferenciasVehiculo(Integer preferenciaAnio, Integer preferenciaKilometros,
			String preferenciaTipoDeVehiculo) {
		this.preferenciaAnio = preferenciaAnio;
		this.preferenciaKilometros = preferenciaKilometros;
		this.preferenciaTipoDeVehiculo = preferenciaTipoDeVehiculo;
	}

	public Integer getPreferenciaKilometros() {
		return preferenciaKilometros;
	}

	public String getPreferenciaTipoDeVehiculo() {
		return preferenciaTipoDeVehiculo;
	}

	public LocalDate getDesde() {
		return desde;
	}

	public void setDesde(LocalDate desde) {
		this.desde = desde;
	}

	public LocalDate getHasta() {
		return hasta;
	}

	public void setHasta(LocalDate hasta) {
		this.hasta = hasta;
	}

	@Override
	public int compareTo(Dueño otro) {
		// TODO Auto-generated method stub
		return otro.getDesde().compareTo(this.desde);
	}

	@Override
	public String toString() {
		return "Dueño [Nombre=" + getNombre() + ", Apellido=" + getApellido() + ", Dni=" + getDni() + ", esPropetario=" + esPropetario + ", desde=" + desde + ", hasta=" + hasta + "]";
	}
	
	

}
