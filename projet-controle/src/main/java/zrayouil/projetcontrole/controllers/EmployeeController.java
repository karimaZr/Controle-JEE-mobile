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

import zrayouil.projetcontrole.entities.Employe;

import zrayouil.projetcontrole.services.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employe createEmploye(@RequestBody Employe employe) {
		employe.setId(0L);
		return employeeService.create(employe);

	}

	@GetMapping
	public List<Employe> getEmployes() {
		return employeeService.getAll();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
		Employe employe = employeeService.getById(id);
		if (employe == null) {
			return new ResponseEntity<Object>("employee with id=" + id + "not found", HttpStatus.BAD_REQUEST);
		} else {
			employeeService.delete(employe);
			return ResponseEntity.ok("employee deleted succefully");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findEmployee(@PathVariable Long id) {
		Employe employe = employeeService.getById(id);
		if (employe == null) {
			return new ResponseEntity<Object>("employee with id=" + id + "not found", HttpStatus.BAD_REQUEST);
		} else {
			return ResponseEntity.ok(employe);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateEmployee(@PathVariable Long id, @RequestBody Employe employe) {
		Employe oldemploye = employeeService.getById(id);
		if (oldemploye == null) {
			return new ResponseEntity<Object>("employee with id=" + id + "not found", HttpStatus.BAD_REQUEST);
		} else {
			employe.setId(id);
			return ResponseEntity.ok(employeeService.update(employe));
		}
	}
	

}
