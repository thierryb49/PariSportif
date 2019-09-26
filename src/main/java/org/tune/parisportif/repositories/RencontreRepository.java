package org.tune.parisportif.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.tune.parisportif.entities.Rencontre;

@CrossOrigin("*")
@RepositoryRestResource
public interface RencontreRepository extends JpaRepository<Rencontre, Long> {
	public Collection<Rencontre> findAllByPhaseId(@Param("id") Long phaseId);	
	public Optional<Rencontre> findByPhaseIdAndTeamDomIdAndTeamExtId(@Param("pid") Long phaseId, @Param("tdi") Long teamDomId, @Param("tei") Long teamExtId);
	//public Collection<Rencontre> findAllByTeamDomId(@Param("id") long teamDomId);	
	//public Collection<Rencontre> findAllByTeamExtId(@Param("id") long teamExtId);
	//public Collection<Rencontre> findAllByTeamDomIdOrTeamExtId(@Param("did") long teamDomId, @Param("eid") long teamExtId);	
}