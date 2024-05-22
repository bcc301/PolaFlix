package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

enum TipoSerie {
	STANDARD,
	SILVER,
	GOLD
}

public class Serie {

    private final long id;
	private String nombreSerie;
	private int numTotalCapitulos;
	private String sinopsis;
	private float precioCapitulo;

	private Set<TrabajadorSerie> actoresPrincipales;
	private Set<TrabajadorSerie> creadores;
	private List<Temporada> temporadas;

	private TipoSerie tipoSerie;

	private static final double precioEstandar = 0.50;
	private static final double precioSilver = 0.75;
	private static final double precioGold = 1.50;
	
	public Serie(long id, String nombreSerie, String sinopsis, TipoSerie tipoSerie) {
		this.id = id;
		this.nombreSerie = nombreSerie;
		this.sinopsis = sinopsis;
		this.tipoSerie = tipoSerie;

		actoresPrincipales = new HashSet<>();
		creadores = new HashSet<>();
		temporadas = new ArrayList<>();

		//TODO: numTotalCaps y precioCapitulo
	}

	/* METODOS DE NEGOCIO */


	public void anadirCapitulo(Capitulo cap) {}

	public void eliminarCapitulo(Capitulo cap) {}

	// TODO: buscaCapitulo

	/* GETTERS Y SETTERS */

	public long getId() {
		return id;
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

	public float getPrecioCapitulo() {
		return precioCapitulo;
	}

	public void setPrecioCapitulo(float precioCapitulo) {
		this.precioCapitulo = precioCapitulo;
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

	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public TipoSerie getTipoSerie() {
		return tipoSerie;
	}

	public void setTipoSerie(TipoSerie tipoSerie) {
		this.tipoSerie = tipoSerie;
	}
    
}
