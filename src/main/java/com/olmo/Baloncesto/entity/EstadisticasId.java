package com.olmo.Baloncesto.entity;

import javax.persistence.Embeddable;

@Embeddable
public class EstadisticasId implements java.io.Serializable {

	private String temporada;
	private int jugador;

	public EstadisticasId() {
	}

	public EstadisticasId(String temporada, int jugador) {
		this.temporada = temporada;
		this.jugador = jugador;
	}

	public String getTemporada() {
		return this.temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public int getJugador() {
		return this.jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstadisticasId))
			return false;
		EstadisticasId castOther = (EstadisticasId) other;

		return ((this.getTemporada() == castOther.getTemporada()) || (this.getTemporada() != null
				&& castOther.getTemporada() != null && this.getTemporada().equals(castOther.getTemporada())))
				&& (this.getJugador() == castOther.getJugador());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTemporada() == null ? 0 : this.getTemporada().hashCode());
		result = 37 * result + this.getJugador();
		return result;
	}

}
