package entity;

public class SalleRadiologie {
	private String idSalle;
	private String nom;
	private int numeroEtage;
	private String typeSalle;
	private String equipementAtrribuId;
	private String normeBlindagePlomb;
	private boolean statutDispo;
	
	public SalleRadiologie(String idSalle, String nom, int numeroEtage, String typeSalle, String equipementAtrribuId,
			String normeBlindagePlomb, boolean statutDispo) {
		super();
		this.idSalle = idSalle;
		this.nom = nom;
		this.numeroEtage = numeroEtage;
		this.typeSalle = typeSalle;
		this.equipementAtrribuId = equipementAtrribuId;
		this.normeBlindagePlomb = normeBlindagePlomb;
		this.statutDispo = statutDispo;
	}
	
	public SalleRadiologie() {
		super();
	}

	public String getIdSalle() {
		return idSalle;
	}
	public void setIdSalle(String idSalle) {
		this.idSalle = idSalle;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getNumeroEtage() {
		return numeroEtage;
	}
	public void setNumeroEtage(int numeroEtage) {
		this.numeroEtage = numeroEtage;
	}
	public String getTypeSalle() {
		return typeSalle;
	}
	public void setTypeSalle(String typeSalle) {
		this.typeSalle = typeSalle;
	}
	public String getEquipementAtrribuId() {
		return equipementAtrribuId;
	}
	public void setEquipementAtrribuId(String equipementAtrribuId) {
		this.equipementAtrribuId = equipementAtrribuId;
	}
	public String getNormeBlindagePlomb() {
		return normeBlindagePlomb;
	}
	public void setNormeBlindagePlomb(String normeBlindagePlomb) {
		this.normeBlindagePlomb = normeBlindagePlomb;
	}
	public boolean isStatutDispo() {
		return statutDispo;
	}
	public void setStatutDispo(boolean statutDispo) {
		this.statutDispo = statutDispo;
	}
}
