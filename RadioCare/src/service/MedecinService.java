package service;

import java.util.List;
import dao.MedecinDao;
import entity.MedecinRadiologue;

public class MedecinService {
	private MedecinDao medecinDao;
	
	public MedecinService() {
		this.medecinDao=new MedecinDao();
	}
	
	public void modifierMedecin(MedecinRadiologue medecin) {
		valider(medecin);
		if(medecinDao.findById(medecin.getIdMedecin())==null) {
			throw new IllegalArgumentException("ERREUR: Le medecin ayant l'ID"+medecin.getIdMedecin()+" n'existe pas!");
		}
		if(medecinDao.findByCin(medecin.getCin())!=null) {
			throw new IllegalArgumentException("ERREUR: Un medecin avec ce CIN existe deja!");
		}
		medecinDao.save(medecin);
	}
	
	public MedecinRadiologue chercherParId(String idMedecin) {
		MedecinRadiologue m = medecinDao.findById(idMedecin);
		if ( m== null) {
			throw new IllegalArgumentException("ERREUR: aucun medecin trouve avec l'ID "+ idMedecin);
		}
		return m;
	}
	
	public MedecinRadiologue chercherParCin(String cin) {
		MedecinRadiologue m = medecinDao.findById(cin);
		if ( m== null) {
			throw new IllegalArgumentException("ERREUR: aucun medecin trouve avec le CIN "+ cin);
		}
		return m;
	}
	
	public List<MedecinRadiologue> listerTousLesMedecins(){
		return medecinDao.findAll();
	}
	
	public void supprimerMedecin(String idMedecin) {
		
		boolean supprime = medecinDao.delete(idMedecin);
		if (!supprime) {
			throw new IllegalArgumentException("ERREUR: impossible de supprimer le medecin  :"+idMedecin + " n'existe pas");
		}
	}
	
	public void ajouterMedecin(MedecinRadiologue medecin) {
		valider(medecin);
		if(medecinDao.findById(medecin.getIdMedecin())!=null) {
			throw new IllegalArgumentException("ERREUR: Un medecin avec cet ID existe deja!");
		}
		if(medecinDao.findByCin(medecin.getCin())!=null) {
			throw new IllegalArgumentException("ERREUR: Un medecin avec ce CIN existe deja!");
		}
		medecinDao.save(medecin);
	}

	private void valider(MedecinRadiologue medecin) {
		if(medecin.getIdMedecin()==null || medecin.getIdMedecin().isEmpty()) {
			throw new IllegalArgumentException("ERREUR: L'Id est obligatoire!");
		}
		if(medecin.getCin()==null||medecin.getCin().isBlank()) {
			throw new IllegalArgumentException("ERREUR: Un medecin doit avoir un CIN!");
		}
		if(medecin.getNom()==null||medecin.getNom().isBlank()) {
			throw new IllegalArgumentException("ERREUR: Un medecin doit avoit un nom enregistre!");
		}
		if(medecin.getPrenom()==null||medecin.getPrenom().isBlank()) {
			throw new IllegalArgumentException("ERREUR: Un medecin doit avoit un prenom enregistre!");
		}
		if(!(alphabetical(medecin.getNom().strip())&&alphabetical(medecin.getPrenom().strip()))) {
			throw new IllegalArgumentException("ERREUR: Le nom et le prenom doivent etre alphabetiques!");
		}
		if(medecin.getSpecialite()==null) {
			throw new IllegalArgumentException("ERREUR: Un medecin doit avoir une specialite!");
		}
		if(medecin.getTarifPourcentageActe()<0 || medecin.getTarifPourcentageActe()>100) {
			throw new IllegalArgumentException("ERREUR: Le tarif du pourcentage doit etre compris entre 0 et 100.");
		}
	}

	private boolean alphabetical(String ch) {
		int i=0;
		while(i<ch.length() && (((int)'A'<=ch.charAt(i) && ch.charAt(i)<=(int)'Z')||((int)'a'<=ch.charAt(i) && (int)'z'<=ch.charAt(i)))) {
			i=i+1;
			if(ch.charAt(i)==' ') {i=i+1;}
		}return i==ch.length();
	}
}
