package es.unican.bcc301.empresariales.polaflix.pojos;

public class Capitulo implements Comparable<Capitulo> {
    
	private long id;
	private String titulo;
	private int numCapitulo;
	private String enlaceVisualizacion; 
	private String descripcion;
	
	private Temporada temporada;
	

	public Capitulo(String titulo, int numCapitulo, String enlaceVisualizacion, String descripcion,
			Temporada temporada) {
		this.titulo = titulo;
		this.numCapitulo = numCapitulo;
		this.enlaceVisualizacion = enlaceVisualizacion;
		this.descripcion = descripcion;
		this.temporada = temporada;
	}
	

	/* METODOS DE NEGOCIO */
    

	/* GETTERS Y SETTERS*/

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


	// Metodos auxiliares

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
		if (this.temporada.getNumTemporada() == cap.temporada.getNumTemporada()) {
			return this.numCapitulo - cap.getNumCapitulo();
		} else {
			return this.temporada.getNumTemporada() - cap.getTemporada().getNumTemporada();
		}
	}
	
}
