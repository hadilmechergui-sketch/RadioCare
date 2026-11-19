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

import entity.SalleRadiologie;

public class SalleDao {
	private String fichier = "data/salles.json";
	private List<SalleRadiologie> salles = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public SalleDao() {
		charger();
	}	
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			SalleRadiologie [] tableau = gson.fromJson(reader, SalleRadiologie[].class);
			if (tableau != null) {
				salles=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichier salles.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(salles , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier salles.json",e);
		}
	}
	
	
	public List<SalleRadiologie> findAll(){
		return salles;
	}
	public SalleRadiologie findById(String idSalle) {
		for(SalleRadiologie p : salles) {
			if(p.getIdSalle().equals(idSalle)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(SalleRadiologie p) {
		salles.add(p);
		sauvegarder();
	}
	
	public void update(SalleRadiologie p) {
		for(int i=0 ; i< salles.size();i++) {
			if (salles.get(i).getIdSalle().equals(p.getIdSalle())) {
				salles.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String idSalle ) {
		SalleRadiologie p = findById(idSalle);
		if (p== null) {
			return false;
		}
		salles.remove(p);
		sauvegarder();
		return true;
	}
}