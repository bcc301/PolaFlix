package es.unican.bcc301.empresariales.polaflix.pojos;

import java.time.LocalDate;

public class VisualizacionCapitulo {

    private LocalDate fechaVisualizacion;
	private int numTemporada;
	private int numCapitulo;

	public Factura factura;
	private Usuario usuario;

	public VisualizacionCapitulo(LocalDate fechaVisualizacion, int numTemporada, int numCapitulo, Factura factura,
			Usuario usuario) {
		this.fechaVisualizacion = fechaVisualizacion;
		this.numTemporada = numTemporada;
		this.numCapitulo = numCapitulo;
		this.factura = factura;
		this.usuario = usuario;
	}

	/* METODOS DE NEGOCIO */

	public float getPrecioVisualizacion() { return 0;}

	/* GETTERS Y SETTERS */

	public LocalDate getFechaVisualizacion() {
		return fechaVisualizacion;
	}

	public void setFechaVisualizacion(LocalDate fechaVisualizacion) {
		this.fechaVisualizacion = fechaVisualizacion;
	}

	public int getNumTemporada() {
		return numTemporada;
	}

	public void setNumTemporada(int numTemporada) {
		this.numTemporada = numTemporada;
	}

	public int getNumCapitulo() {
		return numCapitulo;
	}

	public void setNumCapitulo(int numCapitulo) {
		this.numCapitulo = numCapitulo;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
    
}
