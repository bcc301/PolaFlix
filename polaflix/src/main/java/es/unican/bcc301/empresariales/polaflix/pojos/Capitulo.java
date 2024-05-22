package es.unican.bcc301.empresariales.polaflix.pojos;

public class Capitulo {
    
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
