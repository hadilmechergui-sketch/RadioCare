package dao;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import entity.ExamenMedical;

public class ExamenMedicalDao {
	private String fichier = "data/examens.json";
	
	private List<ExamenMedical> examens = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();
			
	public ExamenMedicalDao() {
		charger();
	}
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			ExamenMedical [] tableau = gson.fromJson(reader, ExamenMedical[].class);
			if (tableau != null) {
				examens =new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichire examens.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(examens , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier examens.json",e);
		}
	}
	
	
	public List<ExamenMedical> findAll(){
		return examens;
	}
	public ExamenMedical findById(String id) {
		for(ExamenMedical p : examens) {
			if(p.getIdExamen().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(ExamenMedical p) {
		examens.add(p);
		sauvegarder();
	}
	
	public void update(ExamenMedical p) {
		for(int i=0 ; i< examens.size();i++) {
			if (examens.get(i).getIdExamen().equals(p.getIdExamen())) {
				examens.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String id ) {
		ExamenMedical p = findById(id);
		if (p== null) {
			return false;
		}
		examens.remove(p);
		sauvegarder();
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
