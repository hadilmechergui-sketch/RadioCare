package entity;

public class statutEquipement {
	private String[] statut= {"En service","En panne","En maintenance"};

	public String[] getStatut() {
		return statut;
	}

	public void setStatut(String[] statut) {
		this.statut = statut;
	}
	
}
