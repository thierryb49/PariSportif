package org.tune.parisportif.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Wither;

@Entity
@Table(name = "utilisateur")
@Data @NoArgsConstructor @AllArgsConstructor @Wither @ToString
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")	
	private Long id;
	@Column(name = "user_name")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "mail")
	private String mail;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private Collection<Pronostic> pronostics;
}
