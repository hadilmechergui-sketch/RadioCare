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

import entity.EquipementImagerie;

public class EquipementDao {
	private String fichier = "data/equipements.json";
	private List<EquipementImagerie> salles = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public EquipementDao() {
		charger();
	}	
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			EquipementImagerie [] tableau = gson.fromJson(reader, EquipementImagerie[].class);
			if (tableau != null) {
				salles=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichier equipements.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(salles , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier equipements.json",e);
		}
	}
	
	
	public List<EquipementImagerie> findAll(){
		return salles;
	}
	public EquipementImagerie findById(String idEquipement) {
		for(EquipementImagerie p : salles) {
			if(p.getIdEquipement().equals(idEquipement)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(EquipementImagerie p) {
		salles.add(p);
		sauvegarder();
	}
	
	public void update(EquipementImagerie p) {
		for(int i=0 ; i< salles.size();i++) {
			if (salles.get(i).getIdEquipement().equals(p.getIdEquipement())) {
				salles.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String idEquipement ) {
		EquipementImagerie p = findById(idEquipement);
		if (p== null) {
			return false;
		}
		salles.remove(p);
		sauvegarder();
		return true;
	}
}