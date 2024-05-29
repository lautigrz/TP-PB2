package unlam.dominio;

import java.util.List;
import java.util.Set;

public interface IConcesionaria{
	
	Set<Vehiculo> listaVehiculosDisponiblesParaVender() throws ConcesionariaVaciaException;
	List<Auto> listaAutosDisponiblesParaVender() throws ConcesionariaVaciaDeAutosException;
	List<Moto> listaMotosDisponiblesParaVender() throws ConcesionariaVaciaDeMotosException;
	boolean generarVenta(Vehiculo vehiculo, Dueño dueñoComprador, Double saldoPagar);
	
	
}
