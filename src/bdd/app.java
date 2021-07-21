package bdd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import excepciones.FechaFinMenorFechaInicioException;
import filtros.EstacionesFiltro;
import modelo.Estacion;
import modelo.EstadoEstacionEnum;
import modelo.Linea;
import modelo.TareaMantenimiento;
import modelo.Tramo;
import modelo.TramosFunciones;
import servicios.VenderBoletoServicio;

/* Clase temporal de apoyo para realizar pruebas de funcionamiento de los repositorios y conexiones a BDD. 
 * Deber� ser descartada en futuras versiones del proyecto
 */
public class app {

	public static void main(String[] args) {

		Estacion est = EstacionesRepo.ObtenerEstacion(3);
		var tdm = TareaMantenimientoRepo.ObtenerActiva(est);
		System.out.print(tdm);
	}

}
