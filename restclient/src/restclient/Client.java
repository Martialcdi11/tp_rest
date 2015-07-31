package restclient;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import restpersist.EmployeEntity;

public class Client {

	public static void main(String[] args) {
		
		javax.ws.rs.client.Client apiemployes = ClientBuilder.newClient();
		WebTarget target = apiemployes.target("http://localhost:8080");
		Invocation.Builder builder = 		target.path("api").path("employes").request();
		// Récupérer l'objet Response
		Response response = builder.get();
		// Récupérer un objet particulier
		List<EmployeEntity> employes = (List<EmployeEntity>) builder.get();
		System.out.format("retour %s \n", employes );
	}
}
