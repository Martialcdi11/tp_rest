package jaxrs.ihm;

import java.util.List;

import javax.ws.rs.WebApplicationException;

import service.CompteService;
import service.CompteServiceService;

import jaxrs.ihm.domain.Employe;
import jaxrs.ihm.util.ScannerUtil;
import jaxrs.service.EmployeClientService;

public class CreerCompteEmploye implements Action {

	@Override
	public Integer getId() {return 5;}

	@Override
	public String getMenu() {return "Créer un compte à un employé";	}

	@Override
	public void execute() {
		List<Employe> employes = null; 
		
		System.out.println("Créer un compte à un employé");
		// TODO Auto-generated method stub
		try {
			
			employes = new EmployeClientService().findAllEmployes();
			
			employes.stream().forEach(employe -> {
				System.out.println(employe);
			});
		} catch (WebApplicationException e) {
			System.out.println("Impossible de récupérer les employes");
		}
		
		Integer choix = ScannerUtil.getInstance().askUserInt("\nVeuillez indiquer l'id de l'employé choisi");
		
		employes.stream().forEach(employe -> {
			if (choix == employe.getId()) {
				// appel du webservcice  !!!!!!! ???????????
				CompteService compteService = new CompteServiceService().getCompteServicePort();
				compteService.create(choix,employe.getNom(), employe.getPrenom());
			}
		});

	}

}
