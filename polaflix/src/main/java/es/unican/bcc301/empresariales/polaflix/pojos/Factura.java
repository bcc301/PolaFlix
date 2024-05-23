package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.Set;
import java.util.TreeSet;
import java.sql.Date;

public class Factura implements Comparable<Factura> {

	private long id;
	private double importeTotal;
	private Date fecha;

	private Set<VisualizacionSerie> entradasFactura;
	private Usuario usuario;

	public Factura(Date fecha, Usuario usuario) {
		this.fecha = fecha;
		this.usuario = usuario;
		this.importeTotal = 0;
		this.entradasFactura = new TreeSet<>();
	}

	/* METODOS DE NEGOCIO */

	public void añadirVisualizacionCapituloAFactura(VisualizacionSerie visualizacion) {}


	// metodos auxiliares

	@Override
	public int compareTo(Factura fact) {
		return Long.compare(this.id, fact.getId());
	}

	@Override
	public boolean equals(Object o) {
		
		Factura fact;

		if (!(o instanceof Factura)) {
			return false;
		} else {
			fact = (Factura) o;
		}

		return this.id == fact.getId();
	}

	@Override
	public int hashCode() {
		return Long.hashCode(this.id);
	}


	
	// gettters y setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<VisualizacionSerie> getEntradasFactura() {
		return entradasFactura;
	}

	public void setEntradasFactura(Set<VisualizacionSerie> entradasFactura) {
		this.entradasFactura = entradasFactura;
	}
}
