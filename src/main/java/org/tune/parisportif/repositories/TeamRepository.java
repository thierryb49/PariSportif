package org.tune.parisportif.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.tune.parisportif.entities.Team;

@CrossOrigin("*")
@RepositoryRestResource
public interface TeamRepository extends JpaRepository<Team, Long> {
	public Optional<Team> findByName(@Param("name") String name);

}
