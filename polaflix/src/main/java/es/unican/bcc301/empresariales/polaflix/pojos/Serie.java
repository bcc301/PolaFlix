package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.rest.JsonViews;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Serie implements Comparable<Serie> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({JsonViews.SerieView.class, JsonViews.UsuarioView.class})
	private long id;
	@JsonView({JsonViews.UsuarioView.class, JsonViews.SerieView.class, JsonViews.FacturaView.class, 
        JsonViews.CapituloView.class})
	private String nombreSerie;
	private int numTotalCapitulos;
	@JsonView({JsonViews.SerieView.class})
	private String sinopsis;
	private char inicial;

	@ElementCollection
	@JsonView(JsonViews.SerieView.class)
	private Set<TrabajadorSerie> actoresPrincipales;
	@ElementCollection
	@JsonView(JsonViews.SerieView.class)
	private Set<TrabajadorSerie> creadores;
	@OneToMany (mappedBy = "serie", cascade = CascadeType.ALL)
	@JsonView(JsonViews.SerieView.class)
	private Set<Temporada> temporadas;
	@ManyToOne
	@JsonView({JsonViews.SerieView.class})
	private Categoria categoria;

	public Serie() { }
	public Serie(String nombreSerie, int numTotalCapitulos, String sinopsis, Categoria categoria) {
		this.nombreSerie = nombreSerie;
		this.numTotalCapitulos = numTotalCapitulos;
		this.sinopsis = sinopsis;
		this.categoria = categoria;
		this.inicial = nombreSerie.charAt(0);

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
	
	//obtener temporada 
	public Temporada getTemporada(int numTemporada) {

		for (Temporada t: temporadas) {
			if (t.getNumTemporada() == numTemporada) {
				return t;
			}
		}

		return null;
	}

	// anadir temporada a la serie
	public void anadirTemporada(Temporada temp) {
		
		if (temp != null) {
			this.temporadas.add(temp);
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
		return this.nombreSerie;
	}

	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}

	public char getInicial() {
		return inicial;
	}
	public void setInicial(char inicial) {
		this.inicial = inicial;
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
