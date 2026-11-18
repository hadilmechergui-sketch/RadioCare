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

import entity.RendezVous;

public class RendezVousDao {
	private String fichier = "data/rendez_vous.json";
	private List<RendezVous> salles = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public RendezVousDao() {
		charger();
	}	
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			RendezVous [] tableau = gson.fromJson(reader, RendezVous[].class);
			if (tableau != null) {
				salles=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichier rendez_vous.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(salles , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier rendez_vous.json",e);
		}
	}
	
	
	public List<RendezVous> findAll(){
		return salles;
	}
	public RendezVous findById(String idRdv) {
		for(RendezVous p : salles) {
			if(p.getIdRdv().equals(idRdv)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(RendezVous p) {
		salles.add(p);
		sauvegarder();
	}
	
	public void update(RendezVous p) {
		for(int i=0 ; i< salles.size();i++) {
			if (salles.get(i).getIdRdv().equals(p.getIdRdv())) {
				salles.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String idRdv ) {
		RendezVous p = findById(idRdv);
		if (p== null) {
			return false;
		}
		salles.remove(p);
		sauvegarder();
		return true;
	}
}