package es.unican.bcc301.empresariales.polaflix.pojos;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.rest.JsonViews;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Capitulo implements Comparable<Capitulo> {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView({JsonViews.CapituloView.class, JsonViews.FacturaView.class})
	private long id;
	@JsonView({JsonViews.SerieView.class, JsonViews.CapituloView.class})
	private String titulo;
	 @JsonView({JsonViews.SerieView.class, JsonViews.FacturaView.class, JsonViews.CapituloView.class})
	private int numCapitulo;
	private String enlaceVisualizacion; 
	@JsonView({JsonViews.CapituloView.class, JsonViews.SerieView.class})
	private String descripcion;
	
	@ManyToOne
	@JsonView({JsonViews.FacturaView.class, JsonViews.CapituloView.class})
	private Temporada temporada;
	
	public Capitulo() { }
	public Capitulo(String titulo, int numCapitulo, String enlaceVisualizacion, String descripcion,
			Temporada temporada) {
		this.titulo = titulo;
		this.numCapitulo = numCapitulo;
		this.enlaceVisualizacion = enlaceVisualizacion;
		this.descripcion = descripcion;
		this.temporada = temporada;
	}
	

	// metodos auxiliares
    
	public Categoria getCategoria() {
		return this.getSerie().getCategoria();
	}

	
	public Serie getSerie() {
		return this.temporada.getSerie();
	}


	@Override
	public boolean equals(Object o) {

		Capitulo cap;

		if (!(o instanceof Capitulo)) {
			return false;
		} else {
			cap = (Capitulo) o;
		}

		return this.id == cap.getId();
	}


	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}


	@Override
	public int compareTo(Capitulo cap) {
		if (this.temporada.getNumTemporada() == cap.getTemporada().getNumTemporada()) {
			return this.numCapitulo - cap.getNumCapitulo();
		} else {
			return this.temporada.getNumTemporada() - cap.getTemporada().getNumTemporada();
		}
	}

	// getters y setters

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getNumCapitulo() {
		return numCapitulo;
	}

	public void setNumCapitulo(int numCapitulo) {
		this.numCapitulo = numCapitulo;
	}

	public String getEnlaceVisualizacion() {
		return enlaceVisualizacion;
	}

	public void setEnlaceVisualizacion(String enlaceVisualizacion) {
		this.enlaceVisualizacion = enlaceVisualizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}
	
}
