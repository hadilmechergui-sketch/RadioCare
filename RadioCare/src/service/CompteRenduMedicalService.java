package service;

import java.util.List;

import dao.CompteRenduMedicalDao;

import entity.CompteRenduMedical;

public class CompteRenduMedicalService {
	private CompteRenduMedicalDao compteRenduDao;
	
	public CompteRenduMedicalService() {
		this.compteRenduDao = new CompteRenduMedicalDao();
	}
	public void ajouterCompteRendu(CompteRenduMedical cr) {
		
		if (cr.getIdCompteRendu() == null || cr.getIdCompteRendu().isEmpty()) {
			throw new IllegalArgumentException("erreur : le idCompteRendu est obligatoire");
		}
		
		if (compteRenduDao.findById(cr.getIdCompteRendu())!= null ) {
			throw new IllegalArgumentException("erreur: un compte rendu avec une idCompteRendu existe deja");
		}
		if (cr.getIdRdv()==null || cr.getIdRdv().isEmpty()){
			throw new IllegalArgumentException("erreur: lid du rdv est obligatoire ");
		}
		if (cr.getTranscriptionDiagnosticTextuel()==null || cr.getTranscriptionDiagnosticTextuel().isEmpty()) {
			throw new IllegalArgumentException("erreur : le diagnostique textuel est obligatoire");
		}
		if (cr.getCodeResultat()==null||(!cr.getCodeResultat().equalsIgnoreCase("normal")&& !cr.getCodeResultat().equalsIgnoreCase("anomalie")&& !cr.getCodeResultat().equalsIgnoreCase("urgent"))){
				throw new IllegalArgumentException("erreur : le code resultat doit etre normal , anomalie ou urgent ");
		}
		compteRenduDao.save(cr);
		
	}
	
	public void modifierCompteRendu(CompteRenduMedical cr) {
		if (compteRenduDao.findById(cr.getIdCompteRendu())==null) {
			throw new IllegalArgumentException("erreur: ce cr n'existe pas");
		}
		compteRenduDao.update(cr);
	}
	
	public void supprimerCompteRenduMedical(String idCompteRendu) {
		
		boolean supprime = compteRenduDao.delete(idCompteRendu);
		if (!supprime) {
			throw new IllegalArgumentException("erreur; imposiiblede supprimer le cr  :"+idCompteRendu + "n'existe pas");
		}
	}
	
	public CompteRenduMedical chercherParId(String idCompteRendu) {
		CompteRenduMedical p = compteRenduDao.findById(idCompteRendu);
		if ( p== null) {
			throw new IllegalArgumentException("erreur: aucun cr trouve avec le idCompteRendu "+ idCompteRendu);
		}
		return p;
	}
	
	public List<CompteRenduMedical> listerTousLesComptesRendus(){
		return compteRenduDao.findAll();
	}
	
	
	
	
}
