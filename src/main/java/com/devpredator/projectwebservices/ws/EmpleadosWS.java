/**
 * 
 */
package com.devpredator.projectwebservices.ws;

import java.util.List;

import com.devpredator.projectwebservices.entity.Empleado;
import com.devpredator.projectwebservices.service.EmpleadoService;
import jakarta.ws.rs.core.Response; 

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.MediaType;

/**
 * @author cesarjimenez
 * 
 * WEBSERVICE GENERADO CON JERSEY
 *
 * USAR METODOS DE EMPLEADOSERVICE
 *
 */
@Path("/empleadosWS")// INDICAR QUE ES UN WB y la ruta
public class EmpleadosWS {
	
	private EmpleadoService empleadoService = new EmpleadoService();
	
	@GET
	@Path("/test")
	public String test() {
		return "Probando WebService con Jersey.";
	}
	
	@GET
	@Path("consultarEmpleado")
	@Produces(MediaType.APPLICATION_JSON)//Anotacion generar formato json
	@Consumes(MediaType.APPLICATION_JSON)
	public Empleado consultarEmpleado() {
		return this.empleadoService.consultarEmpleado();
	}
	
	@GET
	@Path("consultarEmpleados")
	@Produces(MediaType.APPLICATION_JSON)//Anotacion generar formato json
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Empleado> consultarEmpleados() {
		return this.empleadoService.consultarEmpleados();
	}
	
//	// GENERAR CONSULTA APARTIR DE UNA SOLICITUD
//	@GET
//	@Path("consultarEmpleadoPorNumeroEmpleado/{numEmp}") //Agregar el nombre de la variable que sera ingresado
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Empleado consultarEmpleadoPorNumeroEmpleado(@PathParam("numEmp") String numeroEmpleado) {
//		
//		return this.empleadoService.consultarEmpleadoPorId(numeroEmpleado);
//	}
	
	// "RESPONSE" GENERAR CONSULTA APARTIR DE UNA SOLICITUD
	@GET
	@Path("consultarEmpleadoPorNumeroEmpleado/{numEmp}") //Agregar el nombre de la variable que sera ingresado
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consultarEmpleadoPorNumeroEmpleado(@PathParam("numEmp") String numeroEmpleado) {
		
		Empleado empleadoConsultado = this.empleadoService.consultarEmpleadoPorId(numeroEmpleado);
	
		if(empleadoConsultado == null) {
			return Response.noContent().build();
		}
		
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleadoConsultado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
	
	//GENERAR UN POST
	
	@POST
	@Path("guardarEmpleado") //Agregar el nombre de la variable que sera ingresado
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarEmpleado(Empleado empleado) {
		
		if(empleado == null ) {
			return Response.status(400).entity("No se ingresó información del empleado, favro de capturar sus datos").build();
		}
		
		if(empleado.getNombre() == null || empleado.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre es requeridos").build();
		}
		
		GenericEntity<Empleado> empleadoGeneric = new GenericEntity<Empleado>(empleado, Empleado.class);
		return Response.ok(empleadoGeneric).build();
	}
	
}
