package com.devpredator.projectwebservices.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.devpredator.projectwebservices.entity.Empleado;

public class EmpleadoService {

	private Empleado empleado;
	// METODO PARA CONSULTAR POR SU ID
	public Empleado consultarEmpleadoPorId( String numeroEmpleado ) {
		
		List<Empleado> empleadosConsultados = this.consultarEmpleados();
		
		for (Empleado empleadoConsultado : empleadosConsultados ) {
			if (empleadoConsultado.getNumeroEmpleado().equals(numeroEmpleado)) {
				return empleadoConsultado;
			}
		}
		
		return null;
	}
	
	/** 
	 * Metodo que simula la consulta de un empleado
	 *  
	 */
	
	public Empleado consultarEmpleado() {
		
		empleado.setNumeroEmpleado("12345");
		empleado.setNombre("Diego");
		empleado.setPrimerApellido("Paniagua");
		empleado.setSegundoApellido("López");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(31);
		
		return empleado;
	}
	
	// Consultar una lista de empleados, generando datos
	
	public List<Empleado> consultarEmpleados() {
		List<Empleado> empleados = new ArrayList();
		
		Empleado empleado = new Empleado();
		empleado.setNumeroEmpleado("12345");
		empleado.setNombre("Diego");
		empleado.setPrimerApellido("Paniagua");
		empleado.setSegundoApellido("López");
		empleado.setFechaCreacion(LocalDateTime.now());
		empleado.setEdad(31);
		
		Empleado empleadoNuevo = new Empleado();
		empleadoNuevo.setNumeroEmpleado("324324");
		empleadoNuevo.setNombre("Erick");
		empleadoNuevo.setPrimerApellido("Guerrero");
		empleadoNuevo.setSegundoApellido("Gómez");
		empleadoNuevo.setFechaCreacion(LocalDateTime.now());
		empleadoNuevo.setEdad(31);
		
		empleados.add(empleado);
		empleados.add(empleadoNuevo);
		
		return empleados;
	}
	
}
