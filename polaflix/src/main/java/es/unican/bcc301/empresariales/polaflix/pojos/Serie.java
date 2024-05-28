package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Serie implements Comparable<Serie> {

	private long id;
	private String nombreSerie;
	private int numTotalCapitulos;
	private String sinopsis;

	private Set<TrabajadorSerie> actoresPrincipales;
	private Set<TrabajadorSerie> creadores;
	private Set<Temporada> temporadas;
	private Categoria categoria;

	public Serie(String nombreSerie, int numTotalCapitulos, String sinopsis, Categoria categoria) {
		this.nombreSerie = nombreSerie;
		this.numTotalCapitulos = numTotalCapitulos;
		this.sinopsis = sinopsis;
		this.categoria = categoria;

		actoresPrincipales = new HashSet<TrabajadorSerie>();
		creadores = new HashSet<TrabajadorSerie>();
		temporadas = new TreeSet<Temporada>();
	}


	// metodos auxiliares

	// anadir actor a la serie
	public void anadirActor(TrabajadorSerie a) {
		if (a != null) {
			this.actoresPrincipales.add(a);
		}
	}

	// anadir creador a la serie
	public void anadirCreador(TrabajadorSerie c) {
		if (c != null) {
			this.creadores.add(c);
		}
	}
	

	@Override
	public int compareTo(Serie s) {
		return Long.compare(this.id, s.getId());
	}

	@Override
	public boolean equals(Object o) {
		
		Serie s;

		if (!(o instanceof Serie)) {
			return false;
		} else {
			s = (Serie) o;
		}

		return this.id == s.getId();
	}

	@Override
	public int hashCode() {
		return this.nombreSerie.hashCode() + this.sinopsis.hashCode();
	}

	
	// getters y setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombreSerie() {
		return nombreSerie;
	}

	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	public int getNumTotalCapitulos() {
		return numTotalCapitulos;
	}

	public void setNumTotalCapitulos(int numTotalCapitulos) {
		this.numTotalCapitulos = numTotalCapitulos;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public Set<TrabajadorSerie> getActoresPrincipales() {
		return actoresPrincipales;
	}

	public void setActoresPrincipales(Set<TrabajadorSerie> actoresPrincipales) {
		this.actoresPrincipales = actoresPrincipales;
	}

	public Set<TrabajadorSerie> getCreadores() {
		return creadores;
	}

	public void setCreadores(Set<TrabajadorSerie> creadores) {
		this.creadores = creadores;
	}

	public Set<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Set<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
