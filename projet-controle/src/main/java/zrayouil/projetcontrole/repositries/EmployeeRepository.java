package zrayouil.projetcontrole.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import zrayouil.projetcontrole.entities.Employe;
import zrayouil.projetcontrole.entities.Service;

@Repository
public interface EmployeeRepository extends JpaRepository<Employe, Long> {
	

}
