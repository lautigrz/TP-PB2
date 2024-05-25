package unlam.dominio;

public class Empleado extends Persona {
	
	private Double comisionGanada;
	
	public Empleado(String nombre, String apellido, Integer edad, Integer dni, Integer id, Double comisionGanada) {
		super(nombre, apellido, edad, dni, id);
		// TODO Auto-generated constructor stub
		this.comisionGanada = comisionGanada;
	}

	public Double getComisionGanada() {
		return comisionGanada;
	}

	public void setComisionGanada(Double comisionGanada) {
		this.comisionGanada = comisionGanada;
	}
	
}
