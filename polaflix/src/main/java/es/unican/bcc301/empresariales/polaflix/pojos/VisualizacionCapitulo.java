package es.unican.bcc301.empresariales.polaflix.pojos;

import java.time.LocalDate;

public class VisualizacionCapitulo implements Comparable<VisualizacionCapitulo> {

    private LocalDate fechaVisualizacion;
	private int numTemporada;
	private int numCapitulo;
	private double precioVisualizacion;

	public Factura factura;
	private Usuario usuario;

	public VisualizacionCapitulo(LocalDate fechaVisualizacion, int numTemporada, double precioVisualizacion, int numCapitulo, Factura factura,
			Usuario usuario) {
		this.fechaVisualizacion = fechaVisualizacion;
		this.numTemporada = numTemporada;
		this.numCapitulo = numCapitulo;
		this.precioVisualizacion = precioVisualizacion;
		this.factura = factura;
		this.usuario = usuario;
	}


	// metodos auxiliares

	@Override
	public int compareTo(VisualizacionCapitulo vc) {

		if (this.numTemporada == vc.getNumTemporada()) {
			return this.numCapitulo - vc.getNumCapitulo();
		} else {
			return this.numTemporada - vc.getNumTemporada();
		}
	}

	@Override
	public boolean equals(Object o) {

		VisualizacionCapitulo vc;

		if (!(o instanceof VisualizacionCapitulo)) {
			return false;
		} else {
			vc = (VisualizacionCapitulo) o;
		}
		
		return this.fechaVisualizacion.equals(vc.getFechaVisualizacion()) &&
			this.numTemporada == vc.getNumTemporada() &&
				this.numTemporada == vc.getNumTemporada();
	}

	@Override
	public int hashCode() {
		
		return this.fechaVisualizacion.hashCode() * this.numCapitulo * this.numTemporada;
	}

	
	// getters y setters

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

	public double getPrecioVisualizacion() {
		return precioVisualizacion;
	}

	public void setPrecioVisualizacion(double precioVisualizacion) {
		this.precioVisualizacion = precioVisualizacion;
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
