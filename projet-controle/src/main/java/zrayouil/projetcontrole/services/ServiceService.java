package zrayouil.projetcontrole.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import zrayouil.projetcontrole.Dao.Idao;
import zrayouil.projetcontrole.entities.Service;
import zrayouil.projetcontrole.repositries.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService implements Idao<Service> {
    @Autowired
	private ServiceRepository serviceRepository;
	@Override
	public Service update(Service o) {
		// TODO Auto-generated method stub
		return serviceRepository.save(o);
	}

	@Override
	public Service create(Service o) {
		// TODO Auto-generated method stub
		return serviceRepository.save(o);
	}

	@Override
	public boolean delete(Service o) {
		// TODO Auto-generated method stub
		serviceRepository.delete(o);
		return true;
	}

	@Override
	public List<Service> getAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public Service getById(Long id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id).orElse(null);
	}

}
