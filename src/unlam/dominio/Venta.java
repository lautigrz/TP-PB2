package unlam.dominio;

import java.time.LocalDate;

public class Venta {
	
	private static int contador;
	
	private Vehiculo vehiculoVendido;
	private Dueño dueñoComprador;
	private Integer idDeVenta;
	private LocalDate fechaVenta;
	public Venta(Vehiculo vehiculoVendido, Dueño dueñoComprador, LocalDate fechaDeVenta) {
		super();
		this.vehiculoVendido = vehiculoVendido;
		this.dueñoComprador = dueñoComprador;
		this.idDeVenta = contador++;
		this.fechaVenta = fechaDeVenta;
	}
	
	public Dueño getDueñoComprador() {
		return dueñoComprador;
	}
	public void setDueñoComprador(Dueño dueñoComprador) {
		this.dueñoComprador = dueñoComprador;
	}
	public Integer getIdDeVenta() {
		return idDeVenta;
	}
	public void setIdDeVenta(Integer idDeVenta) {
		this.idDeVenta = idDeVenta;
	}

	public Vehiculo getVehiculoVendido() {
		return vehiculoVendido;
	}

	public void setVehiculoVendido(Vehiculo vehiculoVendido) {
		this.vehiculoVendido = vehiculoVendido;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	
	
}
