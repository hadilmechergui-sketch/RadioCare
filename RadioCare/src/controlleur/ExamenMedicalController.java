package controlleur;

import java.util.List;

import entity.ExamenMedical;

import service.ExamenMedicalService;

public class ExamenMedicalController {
	
	private ExamenMedicalService examenService ;

	public ExamenMedicalController() {
		
		this.examenService = new ExamenMedicalService();
	}
	
	public void ajouterExamen(ExamenMedical examen) {
		examenService.ajouterExamenMedical(examen);
	}
	
	 public void modifierExamen(ExamenMedical examen) {
		 examenService.modifierExamenMedical(examen);
	 }
	 public void supprimerExamen(String idExamen) {
		 examenService.supprimerExamenMedical(idExamen);
	 }
	 public ExamenMedical chercherExamen(String idExamen) {
		 return examenService.chercherParidExamen(idExamen);
	 }
	 public List<ExamenMedical> listerExamens(){
		 return examenService.listerTousLesExamenMedical();
	 }
	
	
}
