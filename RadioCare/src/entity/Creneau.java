package entity;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class Creneau {
	private DayOfWeek jour;
	private LocalTime debut;
	private LocalTime fin;
	
	public DayOfWeek getJour() {
		return jour;
	}
	public void setJour(DayOfWeek jour) {
		this.jour = jour;
	}
	public LocalTime getDebut() {
		return debut;
	}
	public void setDebut(LocalTime debut) {
		this.debut = debut;
	}
	public LocalTime getFin() {
		return fin;
	}
	public void setFin(LocalTime fin) {
		this.fin = fin;
	}
	
	public Creneau(DayOfWeek jour, LocalTime debut, LocalTime fin) {
		super();
		this.jour = jour;
		this.debut = debut;
		this.fin = fin;
	}
	
	public Creneau() {
		super();
	}
	
}
