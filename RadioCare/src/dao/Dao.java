package dao;

import java.util.List;
import java.util.Optional;


public interface Dao<T>{
	 List<T> findAll();
	 
	 Optional<T> findById(String id);
	 void save (T entity);
	 void update(T entity);
	 boolean delete(String id);
}
