package service;

import java.util.List;

import dao.ExamenMedicalDao;


import entity.ExamenMedical;


public class ExamenMedicalService {
	
	private ExamenMedicalDao examenDao;
	
	public ExamenMedicalService() {
		this.examenDao = new ExamenMedicalDao();
	}
	public void ajouterExamenMedical(ExamenMedical examen) {
		
		if (examen.getIdExamen() == null || examen.getIdExamen().isEmpty()) {
			throw new IllegalArgumentException("erreur : le idExamen est obligatoire");
		}
		
		if (examenDao.findById(examen.getIdExamen())!= null ) {
			throw new IllegalArgumentException("erreur: un examen avec une idExamen existe deja");
		}
		if (examen.getDureeEstimeeMinutes()<=0 || examen.getTarifHT()<=0) {
			throw new IllegalArgumentException("erreur ; la duree et le tarif doivent etre >0");
		}
		examenDao.save(examen);
	}
	
	public void modifierExamenMedical(ExamenMedical examen) {
		if (examenDao.findById(examen.getIdExamen())==null) {
			throw new IllegalArgumentException("erreur: ce examen n'existe pas");
		}
		if (examen.getDureeEstimeeMinutes()<=0 || examen.getTarifHT()<=0) {
			throw new IllegalArgumentException("erreur ; la duree et le tarif doivent etre >0");
		}
		examenDao.update(examen);
	}
	
	public void supprimerExamenMedical(String idExamen) {
		
		boolean supprime = examenDao.delete(idExamen);
		if (!supprime) {
			throw new IllegalArgumentException("erreur; imposiiblede supprimer le examen  :"+idExamen + "n'existe pas");
		}
	}
	
	public ExamenMedical chercherParidExamen(String idExamen) {
		ExamenMedical e = examenDao.findById(idExamen);
		if ( e== null) {
			throw new IllegalArgumentException("erreur: aucun examen trouve avec le idExamen "+ idExamen);
		}
		return e;
	}
	
	public List<ExamenMedical> listerTousLesExamenMedical(){
		return examenDao.findAll();
	}
	
	
	
	
}
