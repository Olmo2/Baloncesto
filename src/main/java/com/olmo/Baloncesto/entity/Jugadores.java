package com.olmo.Baloncesto.entity;

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
@Table(name = "jugadores")
public class Jugadores implements java.io.Serializable {

	@Id
	private int codigo;
	
	@ManyToOne
	private Equipos equipos;
	
	@Column
	private String nombre;
	
	@Column
	private String procedencia;
	
	@Column
	private String altura;
	
	@Column
	private Integer peso;
	
	@Column
	private String posicion;
	
	@OneToMany(mappedBy="jugadores",cascade= CascadeType.ALL)
	private Set<Estadisticas> estadisticases = new HashSet<Estadisticas>(0);

	public Jugadores() {
	}

	public Jugadores(int codigo) {
		this.codigo = codigo;
	}

	public Jugadores(int codigo, Equipos equipos, String nombre, String procedencia, String altura, Integer peso,
			String posicion, Set<Estadisticas> estadisticases) {
		this.codigo = codigo;
		this.equipos = equipos;
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
		this.estadisticases = estadisticases;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Equipos getEquipos() {
		return this.equipos;
	}

	public void setEquipos(Equipos equipos) {
		this.equipos = equipos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getAltura() {
		return this.altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Integer getPeso() {
		return this.peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Set<Estadisticas> getEstadisticases() {
		return this.estadisticases;
	}

	public void setEstadisticases(Set<Estadisticas> estadisticases) {
		this.estadisticases = estadisticases;
	}

}
