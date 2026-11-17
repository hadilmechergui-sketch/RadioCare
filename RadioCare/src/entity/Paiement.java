package entity;

import java.time.LocalDate;

public class Paiement {
	private String idPaiement;
	private String numFacture;
	private LocalDate datePaiement;
	private double montantRecu;
	private String modePaiement;
	private String referenceTexturellePreuve;
	
	
	public Paiement() {
		
	}


	public Paiement(String idPaiement, String numFacture, LocalDate datePaiement, double montantRecu,
			String modePaiement, String referenceTexturellePreuve) {
		super();
		this.idPaiement = idPaiement;
		this.numFacture = numFacture;
		this.datePaiement = datePaiement;
		this.montantRecu = montantRecu;
		this.modePaiement = modePaiement;
		this.referenceTexturellePreuve = referenceTexturellePreuve;
	}


	public String getIdPaiement() {
		return idPaiement;
	}


	public void setIdPaiement(String idPaiement) {
		this.idPaiement = idPaiement;
	}


	public String getNumFacture() {
		return numFacture;
	}


	public void setNumFacture(String numFacture) {
		this.numFacture = numFacture;
	}


	public LocalDate getDatePaiement() {
		return datePaiement;
	}


	public void setDatePaiement(LocalDate datePaiement) {
		this.datePaiement = datePaiement;
	}


	public double getMontantRecu() {
		return montantRecu;
	}


	public void setMontantRecu(double montantRecu) {
		this.montantRecu = montantRecu;
	}


	public String getModePaiement() {
		return modePaiement;
	}


	public void setModePaiement(String modePaiement) {
		this.modePaiement = modePaiement;
	}


	public String getReferenceTexturellePreuve() {
		return referenceTexturellePreuve;
	}


	public void setReferenceTexturellePreuve(String referenceTexturellePreuve) {
		this.referenceTexturellePreuve = referenceTexturellePreuve;
	}


	@Override
	public String toString() {
		return "Paiement [idPaiement=" + idPaiement + ", numFacture=" + numFacture + ", montantRecu=" + montantRecu
				+ ", modePaiement=" + modePaiement + "]";
	}
	
	
}
