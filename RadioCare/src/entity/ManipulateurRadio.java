package entity;

import java.util.Set;

public class ManipulateurRadio {
	private String idManip;
	private String cin;
	private String nom;
	private String prenom;
	Set<Habilitation> habilitations;
	private double tarifHoraire;
	private boolean statutDispo;
	
	public ManipulateurRadio() {
		super();
	}

	public ManipulateurRadio(String idManip, String cin, String nom, String prenom, Set<Habilitation> habilitations,
			double tarifHoraire, boolean statutDispo) {
		super();
		this.idManip = idManip;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.habilitations = habilitations;
		this.tarifHoraire = tarifHoraire;
		this.statutDispo = statutDispo;
	}
	
	public String getIdManip() {
		return idManip;
	}
	public void setIdManip(String idManip) {
		this.idManip = idManip;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Set<Habilitation> getHabilitations() {
		return habilitations;
	}
	public void setHabilitations(Set<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}
	public double getTarifHoraire() {
		return tarifHoraire;
	}
	public void setTarifHoraire(double tarifHoraire) {
		this.tarifHoraire = tarifHoraire;
	}
	public boolean isStatutDispo() {
		return statutDispo;
	}
	public void setStatutDispo(boolean statutDispo) {
		this.statutDispo = statutDispo;
	}
}
