package org.tune.parisportif.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Wither;

@Entity
@Table(name = "rencontre")
@Data @NoArgsConstructor @AllArgsConstructor @Wither @ToString
public class Rencontre implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	@Column(name = "rencontre_date")
	private Date rencontredate;
	@Column(name = "team_dom_id")
	private Long teamDomId;
	@Column(name = "team_ext_id")
	private Long teamExtId;
	@Column(name = "score_dom")
	private Long scoredom;
	@Column(name = "score_ext")
	private Long scoreext;
	@Column(name = "is_team_dom_win")
	private Boolean isteamdomwin;
	@Column(name = "is_team_ext_win")
	private Boolean isteamextwin;
	@Column(name = "phase_id")
	private Long phaseId;
	@ManyToOne
	@JoinColumn(name = "phase_id", insertable = false, updatable = false)
	private Phase phase;
	@ManyToOne
	@JoinColumn(name = "team_dom_id", insertable = false, updatable = false)
	private Team teamDom;
	@ManyToOne
	@JoinColumn(name = "team_ext_id", insertable = false, updatable = false)
	private Team teamExt;
	@Transient
	private List<Pronostic> pronostic;
}
