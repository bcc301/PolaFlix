package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.Set;
import java.util.TreeSet;
import java.sql.Date;

public class Factura implements Comparable<Factura> {

	private long id;
	private double importeTotal;
	private Date fecha;

	private Set<VisualizacionCapitulo> entradasFactura;
	private Usuario usuario;

	public Factura(Date fecha, Usuario usuario) {
		this.fecha = fecha;
		this.usuario = usuario;
		this.importeTotal = 0;
		this.entradasFactura = new TreeSet<VisualizacionCapitulo>();
	}


	// metodos auxiliares


	// metodo para anadir una visualizacion de un capitulo a la factura de un usuario
	public void anadirVisualizacionCapituloAFactura(VisualizacionCapitulo visualizacion) {

		// comprobar valor no nulo
		if (visualizacion == null) {
			return;
		}

		this.entradasFactura.add(visualizacion);
	}


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

	public Set<VisualizacionCapitulo> getEntradasFactura() {
		return entradasFactura;
	}

	public void setEntradasFactura(Set<VisualizacionCapitulo> entradasFactura) {
		this.entradasFactura = entradasFactura;
	}
	
}
