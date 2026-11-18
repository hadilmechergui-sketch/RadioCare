package service;

import java.util.List;

import dao.PatientDao;

import entity.Patient;

public class PatientService {
	private PatientDao patientDao;
	
	public PatientService() {
		this.patientDao = new PatientDao();
	}
	public void ajouterPatient(Patient patient) {
		
		if (patient.getCinMatricule() == null || patient.getCinMatricule().isEmpty()) {
			throw new IllegalArgumentException("erreur : le cin est obligatoire");
		}
		
		if (patientDao.findById(patient.getCinMatricule())!= null ) {
			throw new IllegalArgumentException("erreur: un patient avec une cin existe deja");
		}
		patientDao.save(patient);
	}
	
	public void modifierPatient(Patient patient) {
		if (patientDao.findById(patient.getCinMatricule())==null) {
			throw new IllegalArgumentException("erreur: ce patient n'existe pas");
		}
		patientDao.update(patient);
	}
	
	public void supprimerPatient(String cin) {
		
		boolean supprime = patientDao.delete(cin);
		if (!supprime) {
			throw new IllegalArgumentException("erreur; imposiiblede supprimer le patient  :"+cin + "n'existe pas");
		}
	}
	
	public Patient chercherParCin(String cin) {
		Patient p = patientDao.findById(cin);
		if ( p== null) {
			throw new IllegalArgumentException("erreur: aucun patient trouve avec le cin "+ cin);
		}
		return p;
	}
	
	public List<Patient> listerTousLesPatients(){
		return patientDao.findAll();
	}
	
	
	
	
}
