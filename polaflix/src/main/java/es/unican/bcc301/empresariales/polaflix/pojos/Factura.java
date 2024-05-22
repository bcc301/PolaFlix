package es.unican.bcc301.empresariales.polaflix.pojos;

import java.util.ArrayList;
import java.sql.Date;

public class Factura implements Comparable<Factura> {

	private long id;
	private double importeTotal;
	private Date fecha;

	private ArrayList<VisualizacionSerie> entradasFactura;
	private Usuario usuario;

	public Factura(Date fecha, Usuario usuario) {
		this.fecha = fecha;
		this.usuario = usuario;
		this.importeTotal = 0;
		this.entradasFactura = new ArrayList<>();
	}

	/* METODOS DE NEGOCIO */

	public void añadirVisualizacionCapituloAFactura(VisualizacionSerie visualizacion) {}

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

	public ArrayList<VisualizacionSerie> getEntradasFactura() {
		return entradasFactura;
	}

	public void setEntradasFactura(ArrayList<VisualizacionSerie> entradasFactura) {
		this.entradasFactura = entradasFactura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

}
