package restpersist;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "employe" database table.
 * 
 */
@Entity
@Table(name="employe")
@NamedQuery(name="EmployeEntity.findAll", query="SELECT e FROM EmployeEntity e")
public class EmployeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="matricule")
	private String matricule;

	@Column(name="nom")
	private String nom;

	@Column(name="prenom")
	private String prenom;

	public EmployeEntity() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}