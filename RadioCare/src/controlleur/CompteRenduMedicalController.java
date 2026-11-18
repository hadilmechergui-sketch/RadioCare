package controlleur;

import java.util.List;

import entity.CompteRenduMedical;
import service.CompteRenduMedicalService;


public class CompteRenduMedicalController {
	private CompteRenduMedicalService compteRenduService;
	
	public CompteRenduMedicalController() {
		this.compteRenduService= new CompteRenduMedicalService() ;
	}
	
	public void ajouterCompteRendu(CompteRenduMedical cr) {
		compteRenduService.ajouterCompteRendu(cr);
	}
	
	 public void modifierCompteRendu(CompteRenduMedical cr) {
		 compteRenduService.modifierCompteRendu(cr);
	 }
	 public void supprimerCompteRendu (String idCompteRendu) {
		 compteRenduService.supprimerCompteRenduMedical(idCompteRendu);
	 }
	 public CompteRenduMedical chercherCompteRendu(String idCompteRendu) {
		 return compteRenduService.chercherParId(idCompteRendu);
	 }
	 public List<CompteRenduMedical> listerComptesRendus(){
		 return compteRenduService.listerTousLesComptesRendus();
	 }
}
