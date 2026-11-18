package controlleur;

import java.util.List;

import entity.Patient;
import service.PatientService;

public class PatientController {
	private PatientService patientService;
	
	public PatientController() {
		this.patientService= new PatientService() ;
	}
	
	public void ajouterPatient(Patient patient) {
		patientService.ajouterPatient(patient);
	}
	
	 public void modifierPatient(Patient patient) {
		 patientService.modifierPatient(patient);
	 }
	 public void supprimerPatient (String cin) {
		 patientService.supprimerPatient(cin);
	 }
	 public Patient chercherPatient(String cin) {
		 return patientService.chercherParCin(cin);
	 }
	 public List<Patient> listerPatients(){
		 return patientService.listerTousLesPatients();
	 }
}
