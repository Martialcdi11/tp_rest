package restapi;

import java.io.Serializable;

public class Virement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer idcompteadebiter;
	Integer idcompteacrediter;
	Double  montant;
	
	
	public Virement(Integer idcompteadebiter, Integer idcompteacrediter,
			Double montant) {
		super();
		this.idcompteadebiter = idcompteadebiter;
		this.idcompteacrediter = idcompteacrediter;
		this.montant = montant;
	}
	
	public Integer getIdcompteadebiter() {
		return idcompteadebiter;
	}
	public void setIdcompteadebiter(Integer idcompteadebiter) {
		this.idcompteadebiter = idcompteadebiter;
	}
	public Integer getIdcompteacrediter() {
		return idcompteacrediter;
	}
	public void setIdcompteacrediter(Integer idcompteacrediter) {
		this.idcompteacrediter = idcompteacrediter;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	
	
}
