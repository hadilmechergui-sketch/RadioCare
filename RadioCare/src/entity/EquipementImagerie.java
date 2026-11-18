package entity;

public class EquipementImagerie {
	private String idEquipement;
	private TypeEquipement type;
	private String marque;
	private double heuresCumules;
	private double heuresRestantesMaintenance;
	private statutEquipement Statut;
	
	public String getIdEquipement() {
		return idEquipement;
	}

	public void setIdEquipement(String idEquipement) {
		this.idEquipement = idEquipement;
	}

	public TypeEquipement getType() {
		return type;
	}

	public void setType(TypeEquipement type) {
		this.type = type;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getHeuresCumules() {
		return heuresCumules;
	}

	public void setHeuresCumules(double heuresCumules) {
		this.heuresCumules = heuresCumules;
	}

	public double getHeuresRestantesMaintenance() {
		return heuresRestantesMaintenance;
	}

	public void setHeuresRestantesMaintenance(double heuresRestantesMaintenance) {
		this.heuresRestantesMaintenance = heuresRestantesMaintenance;
	}

	public statutEquipement getStatut() {
		return Statut;
	}

	public void setStatut(statutEquipement statut) {
		Statut = statut;
	}

	public EquipementImagerie() {
		super();
	}

	public EquipementImagerie(String idEquipement, TypeEquipement type, String marque, double heuresCumules,
			double heuresRestantesMaintenance, statutEquipement statut) {
		super();
		this.idEquipement = idEquipement;
		this.type = type;
		this.marque = marque;
		this.heuresCumules = heuresCumules;
		this.heuresRestantesMaintenance = heuresRestantesMaintenance;
		Statut = statut;
	}
}
