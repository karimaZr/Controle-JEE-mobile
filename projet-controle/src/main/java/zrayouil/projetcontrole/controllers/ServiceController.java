package zrayouil.projetcontrole.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zrayouil.projetcontrole.entities.Service;
import zrayouil.projetcontrole.services.ServiceService;

@RestController
@RequestMapping("/api/v1/service")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@PostMapping
	public Service createService(@RequestBody Service service) {
		return serviceService.create(service);

	}

	@GetMapping
	public List<Service> getServices() {
		return serviceService.getAll();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteServicee(@PathVariable Long id) {
		Service service = serviceService.getById(id);
		if (service == null) {
			return new ResponseEntity<Object>("Servicee with id=" + id + "not found", HttpStatus.BAD_REQUEST);
		} else {
			serviceService.delete(service);
			return ResponseEntity.ok("Servicee deleted succefully");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findServicee(@PathVariable Long id) {
		Service service = serviceService.getById(id);
		if (service == null) {
			return new ResponseEntity<Object>("Servicee with id=" + id + "not found", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(service);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateServicee(@PathVariable Long id, @RequestBody Service service) {
		Service oldService = serviceService.getById(id);
		if (oldService == null) {
			return new ResponseEntity<Object>("Servicee with id=" + id + "not found", HttpStatus.BAD_REQUEST);
		} else {
			service.setId(id);
			return ResponseEntity.ok(serviceService.update(service));
		}
	}

}
