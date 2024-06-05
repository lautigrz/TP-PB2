package unlam.dominio;

import java.util.List;
import java.util.Set;

import exepciones.unlam.ConcesionariaVaciaDeAutosException;
import exepciones.unlam.ConcesionariaVaciaDeMotosException;
import exepciones.unlam.ConcesionariaVaciaException;
import exepciones.unlam.VentaException;
import exepciones.unlam.EmpleadosInexistentesEnConcesionaria;

public interface IConcesionaria{
	
	Set<Vehiculo> listaVehiculosDisponiblesParaVender() throws ConcesionariaVaciaException;
	List<Auto> listaAutosDisponiblesParaVender() throws ConcesionariaVaciaDeAutosException;
	List<Moto> listaMotosDisponiblesParaVender() throws ConcesionariaVaciaDeMotosException;
	boolean generarVenta(Vehiculo vehiculo, Dueño dueñoComprador, Double saldoPagar) throws EmpleadosInexistentesEnConcesionaria, VentaException;
	
	
}
