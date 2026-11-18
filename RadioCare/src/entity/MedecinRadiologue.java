package entity;

import java.util.ArrayList;
import java.util.List;

public class MedecinRadiologue {
	private String idMedecin;
	private String cin;
	private String nom;
	private String prenom;
	private Specialite specialite;
	private double tarifPourcentageActe;
	private List<PlageHoraire> dispoPlanning;
	
	public MedecinRadiologue(String idMedecin, String cin, String nom, String prenom, Specialite specialite,
			double tarifPourcentageActe) {
		super();
		this.idMedecin = idMedecin;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
		this.tarifPourcentageActe = tarifPourcentageActe;
	}
	
	public MedecinRadiologue(String idMedecin, String nom, String prenom, String cin, Specialite specialite,
			double tarifPourcentageActe, List<PlageHoraire> dispoPlanning) {
		super();
		this.idMedecin = idMedecin;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.specialite = specialite;
		this.tarifPourcentageActe = tarifPourcentageActe;
		if(dispoPlanning==null) {this.dispoPlanning=new ArrayList<>();}
		else{this.dispoPlanning = dispoPlanning;}
	}
	public String getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(String idMedecin) {
		this.idMedecin = idMedecin;
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public double getTarifPourcentageActe() {
		return tarifPourcentageActe;
	}
	public void setTarifPourcentageActe(double tarifPourcentageActe) {
		this.tarifPourcentageActe = tarifPourcentageActe;
	}
	public List<PlageHoraire> getDispoPlanning() {
		return dispoPlanning;
	}
	public void setDispoPlanning(List<PlageHoraire> dispoPlanning) {
		this.dispoPlanning = dispoPlanning;
	}
	
	
}
