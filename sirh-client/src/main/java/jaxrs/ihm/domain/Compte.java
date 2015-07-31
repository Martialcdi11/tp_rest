package jaxrs.ihm.domain;

public class Compte {

	private Integer id;
	private Integer idTitulaire;
	private String nom;
	private String nomTitulaire;
	private String prenomTitulaire;
	private double solde;

	public Compte() {}
	
	public Compte(Integer idTitulaire, String nomTitulaire, String prenomTitulaire) {
		super();
		this.idTitulaire = idTitulaire;
		this.nomTitulaire = nomTitulaire;
		this.prenomTitulaire = prenomTitulaire;
	}

	public Integer getId() {return this.id;	}
	public void setId(Integer id) {	this.id = id;}
	public Integer getIdTitulaire() {return this.idTitulaire;	}
	public void setIdTitulaire(Integer idTitulaire) {	this.idTitulaire = idTitulaire;	}

	public String getNom() {return this.nom;}
	public void setNom(String nom) { this.nom = nom;}

	public String getNomTitulaire() {return this.nomTitulaire;	}
	public void setNomTitulaire(String nomTitulaire) {this.nomTitulaire = nomTitulaire;}

	public String getPrenomTitulaire() {return this.prenomTitulaire;}
	public void setPrenomTitulaire(String prenomTitulaire) {this.prenomTitulaire = prenomTitulaire;	}

	public double getSolde() {return this.solde;}
	public void setSolde(double solde) {this.solde = solde;	}
}
