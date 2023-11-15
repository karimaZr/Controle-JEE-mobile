package zrayouil.projetcontrole.Dao;

import java.util.List;

public interface Idao<T> {
	T update(T o);

	T create(T o);

	boolean delete(T o);

	List<T> getAll();

	T getById(Long id);

}
