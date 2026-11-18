package entity;

public class MedecinRadiologue {
	private String idMedecin;
	private String cin;
	private String nom;
	private String prenom;
	private Specialite specialite;
	private double tarifPoourccentageActe;
	private List<Creneau> dispoPlanning;
	
	public MedecinRadiologue(String idMedecin, String nom, String prenom, String cin, Specialite specialite,
			double tarifPoourccentageActe, List<Creneau> dispoPlanning) {
		super();
		this.idMedecin = idMedecin;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.specialite = specialite;
		this.tarifPoourccentageActe = tarifPoourccentageActe;
		this.dispoPlanning = dispoPlanning;
	}
	public String getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(String idMedecin) {
		this.idMedecin = idMedecin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	public double getTarifPoourccentageActe() {
		return tarifPoourccentageActe;
	}
	public void setTarifPoourccentageActe(double tarifPoourccentageActe) {
		this.tarifPoourccentageActe = tarifPoourccentageActe;
	}
	public List<Creneau> getDispoPlanning() {
		return dispoPlanning;
	}
	public void setDispoPlanning(List<Creneau> dispoPlanning) {
		this.dispoPlanning = dispoPlanning;
	}
	
	
}
