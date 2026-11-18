package entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class RendezVous {
	private String idRdv;
	LocalDate date;
	LocalTime HeureDebut;
	int dureeMinutes;
	String idPatient;
	String idMedecin;
	String idManip;
	String idSalle;
	String idExamen;
	StatutRdv satut;
	public String getIdRdv() {
		return idRdv;
	}
	public void setIdRdv(String idRdv) {
		this.idRdv = idRdv;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getHeureDebut() {
		return HeureDebut;
	}
	public void setHeureDebut(LocalTime heureDebut) {
		HeureDebut = heureDebut;
	}
	public int getDureeMinutes() {
		return dureeMinutes;
	}
	public void setDureeMinutes(int dureeMinutes) {
		this.dureeMinutes = dureeMinutes;
	}
	public String getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(String idPatient) {
		this.idPatient = idPatient;
	}
	public String getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(String idMedecin) {
		this.idMedecin = idMedecin;
	}
	public String getIdManip() {
		return idManip;
	}
	public void setIdManip(String idManip) {
		this.idManip = idManip;
	}
	public String getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(String idSalle) {
		this.idSalle = idSalle;
	}
	public String getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(String idExamen) {
		this.idExamen = idExamen;
	}
	public StatutRdv getSatut() {
		return satut;
	}
	public void setSatut(StatutRdv satut) {
		this.satut = satut;
	}
	
	public RendezVous(String idRdv, LocalDate date, LocalTime heureDebut, int dureeMinutes, String idPatient,
			String idMedecin, String idManip, String idSalle, String idExamen, StatutRdv satut) {
		super();
		this.idRdv = idRdv;
		this.date = date;
		HeureDebut = heureDebut;
		this.dureeMinutes = dureeMinutes;
		this.idPatient = idPatient;
		this.idMedecin = idMedecin;
		this.idManip = idManip;
		this.idSalle = idSalle;
		this.idExamen = idExamen;
		this.satut = satut;
	}
	
	public RendezVous(){};
	
}
