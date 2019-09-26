package org.tune.parisportif.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.tune.parisportif.entities.Phase;

@CrossOrigin("*")
@RepositoryRestResource
public interface PhaseRepository extends JpaRepository<Phase, Long> {

}
