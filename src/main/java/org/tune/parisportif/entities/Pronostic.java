package org.tune.parisportif.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Wither;

@Entity
@Table(name = "pronostic")
@Data @NoArgsConstructor @AllArgsConstructor @Wither @ToString
public class Pronostic implements Serializable{
	private static final long serialVersionUID = 1L;	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	@Column(name = "rencontre_id")
	private Long rencontreId;
	@Column(name = "score_dom")
	private Long scoreDom;
	@Column(name = "score_ext")
	private Long scoreExt;
	@Column(name = "is_team_dom_win")
	private Boolean isTeamDomWin;
	@Column(name = "is_team_ext_win")
	private Boolean isTeamExtWin;
	@Column(name = "nb_points")
	private Long points;
	@Column(name = "user_id")
	private Long userId;
	@ManyToOne
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User User;
	@ManyToOne
	@JoinColumn(name = "rencontre_id", insertable = false, updatable = false)
	private Rencontre recontre;
}