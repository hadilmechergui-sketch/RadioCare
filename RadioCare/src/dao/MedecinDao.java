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

import entity.MedecinRadiologue;

public class MedecinDao {
	private String fichier = "data/medecins.json";
	private List<MedecinRadiologue> medecins = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public MedecinDao() {
		charger();
	}
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			MedecinRadiologue [] tableau = gson.fromJson(reader, MedecinRadiologue[].class);
			if (tableau != null) {
				medecins=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichier medecins.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(medecins , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier medecins.json",e);
		}
	}
	
	
	public List<MedecinRadiologue> findAll(){
		return medecins;
	}
	public MedecinRadiologue findById(String idMedecin) {
		for(MedecinRadiologue p : medecins) {
			if(p.getIdMedecin().equals(idMedecin)) {
				return p;
			}
		}
		return null;
	}
	
	public MedecinRadiologue findByCin(String cin) {
		for(MedecinRadiologue p : medecins) {
			if(p.getCin().equals(cin)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(MedecinRadiologue p) {
		medecins.add(p);
		sauvegarder();
	}
	
	public void update(MedecinRadiologue p) {
		for(int i=0 ; i< medecins.size();i++) {
			if (medecins.get(i).getIdMedecin().equals(p.getIdMedecin())) {
				medecins.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String idMedecin ) {
		MedecinRadiologue p = findById(idMedecin);
		if (p== null) {
			return false;
		}
		medecins.remove(p);
		sauvegarder();
		return true;
	}
}