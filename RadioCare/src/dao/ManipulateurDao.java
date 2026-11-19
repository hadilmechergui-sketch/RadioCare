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

import entity.ManipulateurRadio;

public class ManipulateurDao {
	private String fichier = "data/manipulateurs.json";
	private List<ManipulateurRadio> manipulateurs = new ArrayList<>();
	private Gson gson = new GsonBuilder()
			.registerTypeAdapter(LocalDate.class , new LocalDateAdapter())
			.setPrettyPrinting()
			.create();
			
	public ManipulateurDao() {
		charger();
	}
	private void charger() {
		File f = new File(fichier);
		if (!f.exists()) {
			return ;
		}
		try (FileReader reader = new FileReader(f)){
			ManipulateurRadio [] tableau = gson.fromJson(reader, ManipulateurRadio[].class);
			if (tableau != null) {
				manipulateurs=new ArrayList<>(Arrays.asList(tableau));
				
			}
		}catch (IOException e) {
			throw new RuntimeException("impossible de lire le fichier manipulateurs.json",e);
		}
	}
	
	private void sauvegarder() {
		File f = new File(fichier);
		f.getParentFile().mkdirs();
		
		try (FileWriter writer = new FileWriter(f)){
			gson.toJson(manipulateurs , writer);
		}catch (IOException e) {
			throw new RuntimeException("impossible d'ecrire dans le fichier manipulateurs.json",e);
		}
	}
	
	
	public List<ManipulateurRadio> findAll(){
		return manipulateurs;
	}
	public ManipulateurRadio findById(String idManip) {
		for(ManipulateurRadio p : manipulateurs) {
			if(p.getIdManip().equals(idManip)) {
				return p;
			}
		}
		return null;
	}
	
	
	
	
	public void save(ManipulateurRadio p) {
		manipulateurs.add(p);
		sauvegarder();
	}
	
	public void update(ManipulateurRadio p) {
		for(int i=0 ; i< manipulateurs.size();i++) {
			if (manipulateurs.get(i).getIdManip().equals(p.getIdManip())) {
				manipulateurs.set(i, p);
				sauvegarder();
				return ;
			}
		}
	}
	
	public boolean delete(String idManip ) {
		ManipulateurRadio p = findById(idManip);
		if (p== null) {
			return false;
		}
		manipulateurs.remove(p);
		sauvegarder();
		return true;
	}
}