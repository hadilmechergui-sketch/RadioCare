package service;

import dao.ExamenDao;

public class ExamenMedicalService {
	private ExamenDao examenDao;
	public ExamenMedicalService() {
		this.examenDao = new ExamenMedicalDao();
	}
}
