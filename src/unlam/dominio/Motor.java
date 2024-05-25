package unlam.dominio;

public class Motor {
	
	private Integer cantidadCilindros;
	private Double cilindrada;
	private Integer numeroMotor;
	private TipoCombustible tipoCombustible;
	private tipoCajaDeCambios cajaDeCambios;
	
	public Motor(Integer cantidadCilindros, Double cilindrada,Integer numeroMotor, TipoCombustible tipoCombustible,
			tipoCajaDeCambios cajaDeCambios) {
		super();
		this.cantidadCilindros = cantidadCilindros;
		this.cilindrada = cilindrada;
		this.tipoCombustible = tipoCombustible;
		this.cajaDeCambios = cajaDeCambios;
	}

	public Integer getCantidadCilindros() {
		return cantidadCilindros;
	}

	public void setCantidadCilindros(Integer cantidadCilindros) {
		this.cantidadCilindros = cantidadCilindros;
	}

	public Double getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(Double cilindrada) {
		this.cilindrada = cilindrada;
	}

	public TipoCombustible getTipoCombustible() {
		return tipoCombustible;
	}

	public void setTipoCombustible(TipoCombustible tipoCombustible) {
		this.tipoCombustible = tipoCombustible;
	}

	public tipoCajaDeCambios getCajaDeCambios() {
		return cajaDeCambios;
	}

	public void setCajaDeCambios(tipoCajaDeCambios cajaDeCambios) {
		this.cajaDeCambios = cajaDeCambios;
	}

	public Integer getNumeroMotor() {
		return numeroMotor;
	}

	public void setNumeroMotor(Integer numeroMotor) {
		this.numeroMotor = numeroMotor;
	}
	
	
}
