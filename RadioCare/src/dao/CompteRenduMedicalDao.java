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

import entity.CompteRenduMedical;

public class CompteRenduMedicalDao {
	private String fichier = "data/compte_rendus.json";
	private List<CompteRenduMedical> compteRendus = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public CompteRenduMedicalDao() {
		charger();
	}
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			CompteRenduMedical [] tableau = gson.fromJson(reader, CompteRenduMedical[].class);
			if (tableau != null) {
				compteRendus=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichire compteRendus.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(compteRendus , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier compte_rendus.json",e);
		}
	}
	
	
	public List<CompteRenduMedical> findAll(){
		return compteRendus;
	}
	public CompteRenduMedical findById(String idCompteRendu) {
		for(CompteRenduMedical p : compteRendus) {
			if(p.getIdCompteRendu().equals(idCompteRendu)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(CompteRenduMedical p) {
		compteRendus.add(p);
		sauvegarder();
	}
	
	public void update(CompteRenduMedical p) {
		for(int i=0 ; i< compteRendus.size();i++) {
			if (compteRendus.get(i).getIdCompteRendu().equals(p.getIdCompteRendu())) {
				compteRendus.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String idCompteRendu ) {
		CompteRenduMedical p = findById(idCompteRendu);
		if (p== null) {
			return false;
		}
		compteRendus.remove(p);
		sauvegarder();
		return true;
	}
	
	
	
	
	
	
	
	
	
	
}
