package zrayouil.projetcontrole.repositries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zrayouil.projetcontrole.entities.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}
