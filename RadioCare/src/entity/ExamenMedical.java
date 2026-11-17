package entity;

public class ExamenMedical {
	private String idExamen;
	private String codeActe;
	private String libelle ;
	private int dureeEstimeeMinutes;
	private double tarifHT;
	
	private String typeEquipementRequis;//added

	
	public ExamenMedical() {
		//for jsonnn
	}
	public ExamenMedical(String idExamen, String codeActe, String libelle, int dureeEstimeeMinutes, double tarifHT,
			String typeEquipementRequis) {
		
		this.idExamen = idExamen;
		this.codeActe = codeActe;
		this.libelle = libelle;
		this.dureeEstimeeMinutes = dureeEstimeeMinutes;
		this.tarifHT = tarifHT;
		this.typeEquipementRequis = typeEquipementRequis;
	}

	public String getIdExamen() {
		return idExamen;
	}

	public void setIdExamen(String idExamen) {
		this.idExamen = idExamen;
	}

	public String getCodeActe() {
		return codeActe;
	}

	public void setCodeActe(String codeActe) {
		this.codeActe = codeActe;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getDureeEstimeeMinutes() {
		return dureeEstimeeMinutes;
	}

	public void setDureeEstimeeMinutes(int dureeEstimeeMinutes) {
		this.dureeEstimeeMinutes = dureeEstimeeMinutes;
	}

	public double getTarifHT() {
		return tarifHT;
	}

	public void setTarifHT(double tarifHT) {
		this.tarifHT = tarifHT;
	}

	public String getTypeEquipementRequis() {
		return typeEquipementRequis;
	}

	public void setTypeEquipementRequis(String typeEquipementRequis) {
		this.typeEquipementRequis = typeEquipementRequis;
	}

	@Override
	public String toString() {
		return "ExamenMedical [idExamen=" + idExamen + ", libelle=" + libelle + ", dureeEstimeeMinutes="
				+ dureeEstimeeMinutes + "]";
	}
	
	
	
}
