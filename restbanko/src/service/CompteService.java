package service;

import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.CompteEntity;

@WebService
@Stateless   // 
public class CompteService {
	@PersistenceContext EntityManager entityManager;
	
	public CompteEntity create(Integer idTitulaire, String nomTitulaire, String prenomTitulaire){
		CompteEntity compteEntity = new CompteEntity(idTitulaire, nomTitulaire, prenomTitulaire); 
		CompteEntity newcompteEntity = entityManager.merge(compteEntity);
		newcompteEntity.setSolde(0);
		return newcompteEntity;
	} 
	
	public CompteEntity creditage(Integer idcompte, Double montant){
		CompteEntity compteEntity = entityManager.find(CompteEntity.class, idcompte);
		compteEntity.setSolde(compteEntity.getSolde()+montant);
		return compteEntity;
	}
	
}