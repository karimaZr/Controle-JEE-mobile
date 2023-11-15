package zrayouil.projetcontrole.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zrayouil.projetcontrole.Dao.Idao;
import zrayouil.projetcontrole.entities.Employe;
import zrayouil.projetcontrole.repositries.EmployeeRepository;
@Service
public class EmployeeService implements Idao<Employe>{
	@Autowired
    private EmployeeRepository employeeRepository;
	@Override
	public Employe update(Employe o) {
		// TODO Auto-generated method stub
		return employeeRepository.save(o);
		
	}

	@Override
	public Employe create(Employe o) {
		// TODO Auto-generated method stub
		return employeeRepository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		// TODO Auto-generated method stub
		employeeRepository.delete(o);
		return true;
	}

	@Override
	public List<Employe> getAll() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employe getById(Long id) {
		// TODO Auto-generated method stub
		return employeeRepository.findById(id).orElse(null);
	}
	
	
}
