package restapi;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import restpersist.EmployeEntity;
import restservice.EmployeService;


@Path("/employes")
public class employes {
	@EJB EmployeService employeService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmployeEntity> list(){
		List<EmployeEntity> employeEntities = employeService.findAll();
		return employeEntities;
	}
	
	@POST
	@Path("/{nom}/{prenom}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(@PathParam("nom") String nom, @PathParam("prenom") String prenom){
		nom = nom.trim();
		prenom =prenom.trim();
		if (nom == null || prenom == null || nom.isEmpty() || prenom.isEmpty() ){
			throw new WebApplicationException("Champs vides", Status.BAD_REQUEST);  // le texte ne remonte pas en http. 
		}
		
		EmployeEntity employeEntity = new EmployeEntity();
		employeEntity.setNom(nom);
		employeEntity.setPrenom(prenom);
		employeEntity = employeService.create(employeEntity);
		
		ResponseBuilder responsebuilder = Response.status(Status.CREATED);
		responsebuilder.entity(employeEntity);
		return responsebuilder.build();
	
	}

//	@POST
//	@Path("/{nom}/{prenom}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public EmployeEntity create(@PathParam("nom") String nom, @PathParam("prenom") String prenom){
//		EmployeEntity employeEntity = new EmployeEntity();
//		employeEntity.setNom(nom);
//		employeEntity.setPrenom(prenom);
//		employeEntity = employeService.create(employeEntity);
//		return employeEntity;
//	}
	
	@PUT 
	@Path("/virements")
	@Produces(MediaType.APPLICATION_JSON)
	public Response vrirement(@QueryParam("idCompteADebiter") Integer idCompteADebiter,
		@QueryParam("idCompteACrediter") Integer idCompteACrediter,@QueryParam("montant") Double montant){
		
		if (idCompteACrediter == null || idCompteADebiter == null ){
			throw new WebApplicationException("Champs vides", Status.BAD_REQUEST);  // le texte ne remonte pas en http. 
		}
		
		Virement virement = new Virement(idCompteADebiter, idCompteACrediter, montant);
		VirementProducer virementProducer = new VirementProducer();
		virementProducer.sendMessage(virement);
		
		ResponseBuilder responsebuilder = Response.status(Status.OK);
		//responsebuilder.entity();
		return responsebuilder.build();
	
	}	
	
	
}
