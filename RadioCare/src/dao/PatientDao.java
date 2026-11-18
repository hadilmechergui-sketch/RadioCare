package dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.Patient;

public class PatientDao {
	private String fichier = "data/patients.json";
	private List<Patient> patients = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public PatientDao() {
		charger();
	}
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			Patient [] tableau = gson.fromJson(reader, Patient[].class);
			if (tableau != null) {
				patients=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichire patients.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(patients , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier patient.json",e);
		}
	}
	
	
	public List<Patient> findAll(){
		return patients;
	}
	public Patient findById(String cin) {
		for(Patient p : patients) {
			if(p.getCinMatricule().equals(cin)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(Patient p) {
		patients.add(p);
		sauvegarder();
	}
	
	public void update(Patient p) {
		for(int i=0 ; i< patients.size();i++) {
			if (patients.get(i).getCinMatricule().equals(p.getCinMatricule())) {
				patients.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String cin ) {
		Patient p = findById(cin);
		if (p== null) {
			return false;
		}
		patients.remove(p);
		sauvegarder();
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
