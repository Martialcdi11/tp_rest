package restservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import restpersist.EmployeEntity;

@Stateless 
public class EmployeService {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<EmployeEntity> findAll(){
		List<EmployeEntity> employeEntities=entityManager.createNamedQuery("EmployeEntity.findAll",EmployeEntity.class).getResultList(); 
		return employeEntities;
	}

	public EmployeEntity create(EmployeEntity employeEntity) {
		entityManager.persist(employeEntity);
		employeEntity.setMatricule("Mat"+employeEntity.getId());
		return employeEntity;
	}
}
