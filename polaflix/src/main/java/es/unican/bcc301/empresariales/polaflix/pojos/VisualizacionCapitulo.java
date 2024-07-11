package es.unican.bcc301.empresariales.polaflix.pojos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonView;

import es.unican.bcc301.empresariales.polaflix.rest.JsonViews;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class VisualizacionCapitulo implements Comparable<VisualizacionCapitulo> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonView(JsonViews.VisualizacionCapituloView.class)
    private LocalDate fechaVisualizacion;
	@JsonView(JsonViews.VisualizacionCapituloView.class)
	private int numTemporada;
	@JsonView(JsonViews.VisualizacionCapituloView.class)
	private int numCapitulo;
	private double precioVisualizacion;

	@ManyToOne
	public Factura factura;
	@ManyToOne
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
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
