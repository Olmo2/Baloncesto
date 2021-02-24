package com.olmo.Baloncesto.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="equipos")
public class Equipos implements Serializable {

	
	@Id
	private String nombre;
	
	@Column
	private String ciudad;
	
	@Column
	private String conferencia;
	
	@Column
	private String division;
	
	@OneToMany(mappedBy = "equipos",cascade= CascadeType.ALL)
	private Set<Jugadores> jugadoreses = new HashSet<Jugadores>(0);
	
	@OneToMany(mappedBy = "equiposByEquipoVisitante",cascade= CascadeType.ALL)
	private Set<Partidos> partidosesForEquipoVisitante = new HashSet<Partidos>(0);
	
	@OneToMany(mappedBy = "equiposByEquipoLocal",cascade= CascadeType.ALL)
	private Set<Partidos> partidosesForEquipoLocal = new HashSet<Partidos>(0);

	public Equipos() {
	}

	public Equipos(String nombre) {
		this.nombre = nombre;
	}

	public Equipos(String nombre, String ciudad, String conferencia, String division, Set<Jugadores> jugadoreses,
			Set<Partidos> partidosesForEquipoVisitante, Set<Partidos> partidosesForEquipoLocal) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.conferencia = conferencia;
		this.division = division;
		this.jugadoreses = jugadoreses;
		this.partidosesForEquipoVisitante = partidosesForEquipoVisitante;
		this.partidosesForEquipoLocal = partidosesForEquipoLocal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getConferencia() {
		return this.conferencia;
	}

	public void setConferencia(String conferencia) {
		this.conferencia = conferencia;
	}

	public String getDivision() {
		return this.division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public Set<Jugadores> getJugadoreses() {
		return this.jugadoreses;
	}

	public void setJugadoreses(Set<Jugadores> jugadoreses) {
		this.jugadoreses = jugadoreses;
	}

	public Set<Partidos> getPartidosesForEquipoVisitante() {
		return this.partidosesForEquipoVisitante;
	}

	public void setPartidosesForEquipoVisitante(Set<Partidos> partidosesForEquipoVisitante) {
		this.partidosesForEquipoVisitante = partidosesForEquipoVisitante;
	}

	public Set<Partidos> getPartidosesForEquipoLocal() {
		return this.partidosesForEquipoLocal;
	}

	public void setPartidosesForEquipoLocal(Set<Partidos> partidosesForEquipoLocal) {
		this.partidosesForEquipoLocal = partidosesForEquipoLocal;
	}

	@Override
	public String toString() {
		return nombre;
	}

	
	
}
