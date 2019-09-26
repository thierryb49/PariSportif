package org.tune.parisportif.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.tune.parisportif.entities.Pronostic;

@CrossOrigin("*")
@RepositoryRestResource
public interface PronosticRepository extends JpaRepository<Pronostic, Long> {
	public Optional<Pronostic> findByUserIdAndRencontreId(Long userId, Long rencontreId);
	public Collection<Pronostic> findAllByUserId(Long userId);
	
	@Query(value = "select p from Pronostic p, Rencontre r " + 
			"where p.rencontreId = r.id " + 
			"and r.phaseId= :x And p.userId= :u")
	public Collection<Pronostic> pronosticsParPhaseParUser(@Param("x") Long phaseId, @Param("u") Long UserId);
}
